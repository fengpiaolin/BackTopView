package com.slowindy.backtopview.view;

import android.support.v7.widget.RecyclerView;

import com.slowindy.backtopview.listener.OnStateChangeListener;

/**
 * author：   slowindy
 * date：     2016/09/22
 * version    1.0
 * description
 * modify by
 */
public class RecyclerAutoView implements IScrollView {

    private RecyclerView mRecyclerView;
    private int mRefuseShowHeight = 0;
    private boolean isShow = false;
    private int mScrollY;

    private RecyclerAutoView() {

    }

    public RecyclerAutoView(RecyclerView view) {
        mRecyclerView = view;
        mRefuseShowHeight = 800;
    }

    @Override
    public void setListener(final OnStateChangeListener listener) {
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mScrollY += dy;
                if (isShow && mScrollY < mRefuseShowHeight) {
                    listener.hide();
                    isShow = !isShow;
                } else if (!isShow && dy < 0) {
                    listener.show();
                    isShow = !isShow;
                } else if (isShow && dy > 0) {
                    listener.hide();
                    isShow = !isShow;
                }
            }
        });
    }

    @Override
    public void backTop() {
        mRecyclerView.scrollToPosition(0);
        mScrollY = 0;
    }

    @Override
    public void setRefuseShowHeight(int height) {
        mRefuseShowHeight = height;
    }
}
