package com.example.khang.newpro.data.model;

import com.example.khang.newpro.data.listener.ButtonMessageDialogListener;

public class MessageDialogModel {
    private CharSequence title;
    private CharSequence message;

    private CharSequence positiveText;
    private ButtonMessageDialogListener positiveListener;
    private CharSequence negativeText;
    private ButtonMessageDialogListener negativeListener;

    private boolean cancelable;

    public MessageDialogModel() {
        this.cancelable = true;
    }

    public CharSequence getTitle() {
        return title;
    }

    public void setTitle(CharSequence title) {
        this.title = title;
    }

    public CharSequence getMessage() {
        return message;
    }

    public void setMessage(CharSequence message) {
        this.message = message;
    }

    public CharSequence getPositiveText() {
        return positiveText;
    }

    public void setPositiveText(CharSequence positiveText) {
        this.positiveText = positiveText;
    }

    public ButtonMessageDialogListener getPositiveListener() {
        return positiveListener;
    }

    public void setPositiveListener(ButtonMessageDialogListener positiveListener) {
        this.positiveListener = positiveListener;
    }

    public CharSequence getNegativeText() {
        return negativeText;
    }

    public void setNegativeText(CharSequence negativeText) {
        this.negativeText = negativeText;
    }

    public ButtonMessageDialogListener getNegativeListener() {
        return negativeListener;
    }

    public void setNegativeListener(ButtonMessageDialogListener negativeListener) {
        this.negativeListener = negativeListener;
    }

    public boolean isCancelable() {
        return cancelable;
    }

    public void setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
    }
}
