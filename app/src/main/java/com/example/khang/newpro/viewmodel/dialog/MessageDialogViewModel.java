package com.example.khang.newpro.viewmodel.dialog;

import android.databinding.ObservableField;
import android.support.v4.app.DialogFragment;

import com.example.khang.newpro.base.BaseViewModel;
import com.example.khang.newpro.base.SingleLiveEvent;
import com.example.khang.newpro.data.listener.ButtonMessageDialogListener;
import com.example.khang.newpro.data.model.MessageDialogModel;

public class MessageDialogViewModel extends BaseViewModel {
    private ObservableField<CharSequence> mTitle = new ObservableField<>();
    private ObservableField<Boolean> mIsShowTitle = new ObservableField<>(false);
    private ObservableField<CharSequence> mMessage = new ObservableField<>();
    private ObservableField<CharSequence> mPositiveText = new ObservableField<>();
    private ButtonMessageDialogListener mPositiveListener;
    private SingleLiveEvent<Void> mPositiveEvent = new SingleLiveEvent<>();
    private ObservableField<CharSequence> mNegativeText = new ObservableField<>();
    private ButtonMessageDialogListener mNegativeListener;
    private SingleLiveEvent<Void> mNegativeEvent = new SingleLiveEvent<>();

    public void setupModel(DialogFragment dialogFragment, MessageDialogModel messageDialogModel) {
        this.setTitle(messageDialogModel.getTitle());
        this.setMessage(messageDialogModel.getMessage());
        this.setPositive(messageDialogModel.getPositiveText(), messageDialogModel.getPositiveListener());
        this.setNegative(messageDialogModel.getNegativeText(), messageDialogModel.getNegativeListener());

        dialogFragment.setCancelable(messageDialogModel.isCancelable());
    }

    public CharSequence getTitle() {
        return mTitle.get();
    }

    public Boolean isShowTitle() {
        return mIsShowTitle.get();
    }

    private void setTitle(CharSequence title) {
        this.mIsShowTitle.set(title != null);
        if (title != null) {
            this.mTitle.set(title);
        }
    }

    public CharSequence getMessage() {
        return mMessage.get();
    }

    private void setMessage(CharSequence message) {
        this.mMessage.set(message);
    }

    public CharSequence getPositiveText() {
        return mPositiveText.get();
    }

    public CharSequence getNegativeText() {
        return mNegativeText.get();
    }

    public ButtonMessageDialogListener getPositiveListener() {
        return mPositiveListener;
    }

    public ButtonMessageDialogListener getNegativeListener() {
        return mNegativeListener;
    }

    private void setPositive(CharSequence positiveText, ButtonMessageDialogListener listener) {
        mPositiveText.set(positiveText);
        mPositiveListener = listener;
    }

    private void setNegative(CharSequence negativeText, ButtonMessageDialogListener listener) {
        mNegativeText.set(negativeText);
        mNegativeListener = listener;
    }

    public SingleLiveEvent<Void> getPositiveEvent() {
        return this.mPositiveEvent;
    }

    public SingleLiveEvent<Void> getNegativeEvent() {
        return this.mNegativeEvent;
    }

    public void onPositiveEvent() {
        mPositiveEvent.call();
    }

    public void onNegativeEvent() {
        mNegativeEvent.call();
    }
}
