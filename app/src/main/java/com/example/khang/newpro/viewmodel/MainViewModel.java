package com.example.khang.newpro.viewmodel;

import android.content.Intent;
import android.databinding.ObservableField;

import com.example.khang.newpro.activity.DetailActivity;
import com.example.khang.newpro.base.BaseActivity;
import com.example.khang.newpro.base.BaseViewModel;
import com.example.khang.newpro.base.SingleLiveEvent;
import com.example.khang.newpro.enums.DetailType;
import com.example.khang.newpro.utils.DetailActivityUtils;

public class MainViewModel extends BaseViewModel {

    private SingleLiveEvent<Void> mChangeTextAndCallActivityEvent = new SingleLiveEvent<>();

    private SingleLiveEvent<Void> mStartProgressEvent = new SingleLiveEvent<>();

    private SingleLiveEvent<Void> mStartVersionDetailActivityEvent = new SingleLiveEvent<>();

    private SingleLiveEvent<Void> mStartListUserDetailActivityEvent = new SingleLiveEvent<>();

    public ObservableField<String> tvHello = new ObservableField<>();

    public SingleLiveEvent<Void> getChangeTextAndCallActivityEvent() {
        return mChangeTextAndCallActivityEvent;
    }

    public SingleLiveEvent<Void> getStartProgressEvent() {
        return mStartProgressEvent;
    }

    public SingleLiveEvent<Void> getStartVersionDetailActivityEvent() {
        return mStartVersionDetailActivityEvent;
    }

    public SingleLiveEvent<Void> getStartListUserDetailActivityEvent() {
        return mStartListUserDetailActivityEvent;
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
    public void startVersionDetailActivityEvent() {
        mStartVersionDetailActivityEvent.call();
    }

    public void onStartVersionDetailActivity(BaseActivity baseActivity) {
        DetailActivityUtils.startDetailActivity(baseActivity, DetailType.VERSION_APP_DETAIL, null, false, null);
    }

    /**
     * View (xml) call to ViewModel And Call Event To Main Activity
     */
    public void startListUserDetailActivityEvent() {
        mStartListUserDetailActivityEvent.call();
    }

    public void onStartListUserDetailActivity(BaseActivity baseActivity) {
        DetailActivityUtils.startDetailActivity(baseActivity, DetailType.LIST_USER_DETAIL, null, false, null);
    }
}
