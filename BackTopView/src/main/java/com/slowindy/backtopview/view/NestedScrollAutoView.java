package com.slowindy.backtopview.view;

import android.support.v4.widget.NestedScrollView;

import com.slowindy.backtopview.listener.OnStateChangeListener;

/**
 * author：   slowindy
 * date：     2016/09/22
 * version    1.0
 * description
 * modify by
 */
public class NestedScrollAutoView implements IScrollView {

    private NestedScrollView mNestedScrollView;
    /**
     * height for hide backTopView
     */
    private int mRefuseShowHeight;
    /**
     * view status for show or hide
     */
    private boolean isShow = false;
    /**
     * scroll distance
     */
    private int mScrollY;

    private NestedScrollAutoView() {

    }

    public NestedScrollAutoView(NestedScrollView view) {
        mNestedScrollView = view;
        mRefuseShowHeight = 800;
    }

    @Override
    public void setListener(final OnStateChangeListener listener) {
        mNestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                int distance = scrollY - oldScrollY;
                mScrollY += distance;
                if (isShow && mScrollY < mRefuseShowHeight) {
                    listener.hide();
                    isShow = !isShow;
                } else if (!isShow && distance < 0) {
                    listener.show();
                    isShow = !isShow;
                } else if (isShow && distance > 0) {
                    listener.hide();
                    isShow = !isShow;
                }
            }
        });
    }

    @Override
    public void backTop() {
        mNestedScrollView.smoothScrollTo(0, 0);
        mScrollY = 0;
    }

    @Override
    public void setRefuseShowHeight(int height) {
        mRefuseShowHeight = height;
    }
}
