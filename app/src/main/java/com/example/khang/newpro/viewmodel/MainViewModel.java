package com.example.khang.newpro.viewmodel;

import android.content.Intent;
import android.databinding.ObservableField;

import com.example.khang.newpro.activity.DetailActivity;
import com.example.khang.newpro.base.BaseActivity;
import com.example.khang.newpro.base.BaseViewModel;
import com.example.khang.newpro.base.SingleLiveEvent;

public class MainViewModel extends BaseViewModel {

    private SingleLiveEvent<Void> mChangeTextAndCallActivityEvent = new SingleLiveEvent<>();

    private SingleLiveEvent<Void> mStartProgressEvent = new SingleLiveEvent<>();

    private SingleLiveEvent<Void> mStartDetailActivityEvent = new SingleLiveEvent<>();

    public ObservableField<String> tvHello = new ObservableField<>();

    public SingleLiveEvent<Void> getChangeTextAndCallActivityEvent() {
        return mChangeTextAndCallActivityEvent;
    }

    public SingleLiveEvent<Void> getStartProgressEvent() {
        return mStartProgressEvent;
    }

    public SingleLiveEvent<Void> getStartDetailActivityEvent() {
        return mStartDetailActivityEvent;
    }

    /**
     * View (xml) call to ViewModel And Call To Activity
     */
    // ... EventchangeTextEvent
    public void changeTextAndCallActivityEvent() {
        mChangeTextAndCallActivityEvent.call();
    }

    public void changeTextEvent() {
        mStartProgressEvent.call();
        tvHello.set("changeTextEvent");
    }

    /**
     * View (xml) call to ViewModel And Change Text
     */
    public void onChangeText() {
        mStartProgressEvent.call();
        tvHello.set("changeTextAndCallActivityEvent");
    }

    /**
     * View (xml) call to ViewModel And Call Event To Main Activity
     */
    public void startDetailActivityEvent() {
        mStartDetailActivityEvent.call();
    }

    public void onStartDetailActivity(BaseActivity baseActivity) {
        baseActivity.startActivity(new Intent(baseActivity, DetailActivity.class));
    }
}
