package com.example.lyl.mvp.daggermodule;

import com.example.lyl.mvp.view.MainActivity;
import com.example.lyl.mvp.view.MainActivityView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dllo on 18/3/27.
 */

@Module
public class MainModule {
    private MainActivityView view;

    public MainModule(MainActivityView view) {
        this.view = view;
    }

    @Provides
    MainActivityView provideMainActivityView () {
        return view;
    }
}
