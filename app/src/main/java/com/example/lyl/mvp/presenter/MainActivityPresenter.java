package com.example.lyl.mvp.presenter;


import com.example.lyl.mvp.bean.GankBean;

/**
 * Created by dllo on 18/3/20.
 */

public interface MainActivityPresenter {
    //这是留给View层去调用Module层请求的方法
    void getGankBean();

    //下面四个方法是P层对Module层请求状态的监听(请求成功,开始请求,请求结束,请求失败)
    void getGankBeansuccess(GankBean gankBean);
    void getGankBeanStart();
    void getGankBeanFailed();
    void getGankBeanFinish();
}
