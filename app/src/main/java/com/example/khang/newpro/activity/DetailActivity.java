package com.example.khang.newpro.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;

import com.example.khang.newpro.R;
import com.example.khang.newpro.base.BaseActivity;
import com.example.khang.newpro.databinding.ActivityDetailBinding;
import com.example.khang.newpro.viewmodel.DetailViewModel;

public class DetailActivity extends BaseActivity {

    private ActivityDetailBinding activityDetailBinding;
    private DetailViewModel detailViewModel;

    /**
     * config bindView bind to layout
     */
    @Override
    protected void bindView() {
        activityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
    }

    /**
     * config ViewModel
     * binding ViewModel
     */
    @Override
    protected void setupViewModel() {
        if (detailViewModel == null) {
            detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
            activityDetailBinding.setDetailViewModel(detailViewModel);
        }
    }

    @Override
    protected void setupData() {
        detailViewModel.replaceFragments(this);
    }
}
