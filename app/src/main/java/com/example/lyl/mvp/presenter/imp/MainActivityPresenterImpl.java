package com.example.lyl.mvp.presenter.imp;


import com.example.lyl.mvp.bean.GankBean;
import com.example.lyl.mvp.module.GankBeanModule;
import com.example.lyl.mvp.module.imp.GankBeanModuleImpl;
import com.example.lyl.mvp.presenter.MainActivityPresenter;
import com.example.lyl.mvp.view.MainActivityView;

import javax.inject.Inject;

/**
 * Created by dllo on 18/3/20.
 */

public class MainActivityPresenterImpl implements MainActivityPresenter {
    private MainActivityView view;

    private GankBeanModule gankBeanModule;

    @Inject
    public MainActivityPresenterImpl(MainActivityView view) {
        //在构造方法中初始化View层和Module层的对象
        this.view = view;
        gankBeanModule = new GankBeanModuleImpl();
    }

    @Override
    public void getGankBean() {
        gankBeanModule.getGankBean(this);
    }

    //module层请求的回调并调用View层相对应状态的方法
    @Override
    public void getGankBeansuccess(GankBean gankBean) {
        view.success(gankBean);
    }

    @Override
    public void getGankBeanStart() {
        view.onStartGetData();
    }

    @Override
    public void getGankBeanFailed() {
        view.onFailedGetData();
    }

    @Override
    public void getGankBeanFinish() {
        view.onFinishGetData();
    }

}
