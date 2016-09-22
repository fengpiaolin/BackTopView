package com.slowindy.backtopview.view;

import com.slowindy.backtopview.listener.OnStateChangeListener;

/**
 * author：   slowindy
 * date：     2016/09/22
 * version    1.0
 * description
 * modify by
 */
public interface IScrollView {

    void setListener(OnStateChangeListener listener);


    void backTop();

    /**
     * set height for hide this view
     *
     * @param height height for hide backTopView
     */
    void setRefuseShowHeight(int height);
}
