package com.example.lyl.mvp.module;

import com.example.lyl.mvp.presenter.MainActivityPresenter;

/**
 * Created by dllo on 18/3/20.
 */

public interface GankBeanModule {
    //把P层的接口作为方法参数传递进来
    void getGankBean(MainActivityPresenter presenter);
}
