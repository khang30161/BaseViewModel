package com.example.khang.newpro.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        setupViewModel();
        setupData();
    }
    protected abstract void bindView();
    protected abstract void setupViewModel();
    protected abstract void setupData();
}
