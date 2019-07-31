package com.example.khang.newpro.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;

import com.example.khang.newpro.R;
import com.example.khang.newpro.base.BaseActivity;
import com.example.khang.newpro.databinding.ActivityMainBinding;
import com.example.khang.newpro.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void bindView() {
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    protected void setupViewModel() {
        if (mainViewModel == null) {
            mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
            activityMainBinding.setMainViewModel(mainViewModel);
        }
    }

    @Override
    protected void setupData() {
        activityMainBinding.tvChangeInActivity.setText("Ahihihi");
        mainViewModel.getChangeTextEvent().observe(this, aVoid -> {
            mainViewModel.onChangeText();
        });
        mainViewModel.getStartProgressEvent().observe(this, aVoid -> {

        });
    }
}
