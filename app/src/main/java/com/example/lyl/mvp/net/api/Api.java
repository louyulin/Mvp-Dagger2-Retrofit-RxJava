package com.example.lyl.mvp.net.api;


import com.example.lyl.mvp.bean.GankBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by dllo on 18/3/20.
 */

public interface Api {
    @GET("data/Android/10/1")
    Observable<GankBean> getGankBean();
}
