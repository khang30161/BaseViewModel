package com.example.khang.newpro.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;

import com.example.khang.newpro.R;
import com.example.khang.newpro.base.BaseActivity;
import com.example.khang.newpro.databinding.ActivityMainBinding;
import com.example.khang.newpro.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    /**
     * config bindView bind to layout
     */
    @Override
    protected void bindView() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    /**
     * config ViewModel
     * binding ViewModel
     */
    @Override
    protected void setupViewModel() {
        if (mainViewModel == null) {
            mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
            activityMainBinding.setMainViewModel(mainViewModel);
        }
    }

    /**
     * config ComeBack ViewModel to Activity
     */
    @Override
    protected void setupData() {
        activityMainBinding.tvChangeInActivity.setText("Ahihihi");

        mainViewModel.getChangeTextAndCallActivityEvent().observe(this, aVoid -> {
            mainViewModel.onChangeText();
        });

        mainViewModel.getStartProgressEvent().observe(this, aVoid -> {

        });

        mainViewModel.getStartVersionDetailActivityEvent().observe(this, aVoid -> {
            mainViewModel.onStartVersionDetailActivity(this);
        });

        mainViewModel.getStartListUserDetailActivityEvent().observe(this, aVoid -> {
            mainViewModel.onStartListUserDetailActivity(this);
        });
    }
}
