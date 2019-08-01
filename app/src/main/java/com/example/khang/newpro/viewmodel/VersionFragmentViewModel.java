package com.example.khang.newpro.viewmodel;

import android.databinding.ObservableField;

import com.example.khang.newpro.BuildConfig;
import com.example.khang.newpro.base.BaseViewModel;

public class VersionFragmentViewModel extends BaseViewModel {

    public ObservableField<String> version = new ObservableField<>("");

    public void getVersion() {
        version.set(BuildConfig.VERSION_NAME_DISPLAY);
    }
}
