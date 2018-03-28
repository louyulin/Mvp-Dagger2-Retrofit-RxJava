package com.example.lyl.mvp.daggercomponent;

import com.example.lyl.mvp.daggermodule.MainModule;
import com.example.lyl.mvp.view.MainActivity;

import dagger.Component;

/**
 * Created by dllo on 18/3/27.
 */

@Component(modules = MainModule.class)
public interface MainActivityComponent {
    public void inject(MainActivity mainActivity);
}
