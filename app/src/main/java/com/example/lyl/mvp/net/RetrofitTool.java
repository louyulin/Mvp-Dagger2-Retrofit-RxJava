package com.example.lyl.mvp.net;

import com.example.lyl.mvp.net.api.Api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dllo on 18/3/20.
 */

public class RetrofitTool {
    public static RetrofitTool instance;
    private Retrofit retrofit;
    private final Api api;

    public Api getApi() {
        return api;
    }

    private RetrofitTool() {
        //初始化Retrofit
        retrofit = new Retrofit.Builder().baseUrl("http://gank.io/api/")
                //给Retrofit添加Gson解析功能
                .addConverterFactory(GsonConverterFactory.create())
                //给Retrofit添加Rxjava功能
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //初始化Retrofit的Api接口
        api = retrofit.create(Api.class);
    }

    //线程锁单例
    public static RetrofitTool getInstance() {
        if (instance == null) {
            synchronized (RetrofitTool.class) {
                if (instance == null) {
                    instance = new RetrofitTool();
                }
            }
        }
        return instance;
    }
}
