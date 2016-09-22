package com.slowindy.backtopview.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.util.AttributeSet;
import android.view.View;

import com.slowindy.backtopview.listener.OnStateChangeListener;

/**
 * author：   slowindy
 * date：     2016/09/22
 * version    1.0
 * description
 * modify by
 */
public class BackTopView extends FloatingActionButton {

    private IScrollView mScrollView;

    public BackTopView(Context context) {
        this(context, null);
    }

    public BackTopView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BackTopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }

    /**
     * set listener for onclick & hide
     */
    private void setListener() {
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mScrollView.backTop();
            }
        });
        mScrollView.setListener(new OnStateChangeListener() {
            @Override
            public void hide() {
                BackTopView.this.hide();
            }

            @Override
            public void show() {
                BackTopView.this.show();
            }
        });
    }

    /**
     * bind scrollView
     *
     * @param view IScrollView
     */
    public void bindView(@NonNull IScrollView view) {
        mScrollView = view;
        setListener();
    }


}
