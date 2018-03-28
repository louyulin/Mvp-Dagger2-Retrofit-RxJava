package com.example.lyl.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import com.example.lyl.mvp.R;
import com.example.lyl.mvp.bean.GankBean;
import com.example.lyl.mvp.daggercomponent.DaggerMainActivityComponent;
import com.example.lyl.mvp.daggermodule.MainModule;
import com.example.lyl.mvp.presenter.imp.MainActivityPresenterImpl;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity implements MainActivityView {

    @Inject
    public MainActivityPresenterImpl presenter;
    public TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.tv1);
        //获取P层实例并把view层传给P层
        DaggerMainActivityComponent.builder().build().inject(this);
        //调用P层请求方法
        presenter.getGankBean();

    }


    @Override
    public void success(GankBean gankBean) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <gankBean.getResults().size() ; i++) {
            sb.append(gankBean.getResults().get(i).getUrl() + "\n");
        }
        tv1.setText(sb);
    }

    @Override
    public void onStartGetData() {
        tv1.setText("正在加载");
    }

    @Override
    public void onFailedGetData() {
        tv1.setText("加载失败");
    }

    @Override
    public void onFinishGetData() {
        Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
    }
}
