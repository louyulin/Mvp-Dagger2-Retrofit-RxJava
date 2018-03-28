package com.example.lyl.mvp.view;


import com.example.lyl.mvp.bean.GankBean;

/**
 * Created by dllo on 18/3/20.
 */

public interface MainActivityView {
    void success(GankBean gankBean);
    void onStartGetData();
    void onFailedGetData();
    void onFinishGetData();
}
