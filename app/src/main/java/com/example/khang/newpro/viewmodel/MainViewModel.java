package com.example.khang.newpro.viewmodel;

import android.databinding.ObservableField;

import com.example.khang.newpro.base.BaseViewModel;
import com.example.khang.newpro.base.SingleLiveEvent;

public class MainViewModel extends BaseViewModel {

    private SingleLiveEvent<Void> mChangeTextEvent = new SingleLiveEvent<>();

    private SingleLiveEvent<Void> mStartProgressEvent = new SingleLiveEvent<>();

    public ObservableField<String> tvHello = new ObservableField<>();

    public SingleLiveEvent<Void> getChangeTextEvent() {
        return mChangeTextEvent;
    }

    public SingleLiveEvent<Void> getStartProgressEvent() {
        return mStartProgressEvent;
    }

    // ... EventchangeTextEvent
    public void changeTextEvent(){
        mChangeTextEvent.call();
    }

    public void onChangeText (){
        mStartProgressEvent.call();
        tvHello.set("12354");
    }
}
