package com.example.lyl.mvp.module.imp;


import com.example.lyl.mvp.bean.GankBean;
import com.example.lyl.mvp.module.GankBeanModule;
import com.example.lyl.mvp.net.RetrofitTool;
import com.example.lyl.mvp.presenter.MainActivityPresenter;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dllo on 18/3/20.
 */

public class GankBeanModuleImpl implements GankBeanModule {
    @Inject
    public GankBeanModuleImpl() {
    }

    @Override
    public void getGankBean(final MainActivityPresenter presenter) {
        //开始请求
        presenter.getGankBeanStart();
        //Retrofit开始请求
        RetrofitTool.getInstance().getApi()
                .getGankBean()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<GankBean>() {
                    @Override
                    public void accept(GankBean gankBean) throws Exception {
                        //请求成功并调用P层的监听方法
                        presenter.getGankBeansuccess(gankBean);
                        presenter.getGankBeanFinish();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //请求失败的监听调用
                        presenter.getGankBeanFailed();
                        throwable.printStackTrace();
                    }
                });
    }
}
