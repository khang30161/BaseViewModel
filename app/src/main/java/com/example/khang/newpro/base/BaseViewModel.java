package com.example.khang.newpro.base;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.khang.newpro.viewmodel.Event;

public class BaseViewModel extends ViewModel {
    public MutableLiveData<Event> eventLoading = new MutableLiveData<Event>();

    public MutableLiveData<Event<Throwable>> eventFailure = new MutableLiveData<Event<Throwable>>();

    public void showLoading(boolean value){
        eventLoading.setValue(new Event(value));
    }

    public void showFailure(Throwable throwable) {
        eventFailure.setValue(new Event(throwable));
    }
}
