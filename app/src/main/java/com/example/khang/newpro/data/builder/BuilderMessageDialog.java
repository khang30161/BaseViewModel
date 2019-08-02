package com.example.khang.newpro.data.builder;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;

import com.example.khang.newpro.data.listener.ButtonMessageDialogListener;
import com.example.khang.newpro.data.model.MessageDialogModel;
import com.example.khang.newpro.ui.dialog.MessageDialogFragment;

public class BuilderMessageDialog {

    private Context mContext;
    private FragmentManager mFragmentManager;

    private MessageDialogModel mMessageDialogModel;

    public BuilderMessageDialog(Context context, FragmentManager fragmentManager) {
        this.mContext = context;
        this.mFragmentManager = fragmentManager;
        mMessageDialogModel = new MessageDialogModel();
    }

    public BuilderMessageDialog setTitle(@StringRes int titleId) {
        mMessageDialogModel.setTitle(mContext.getText(titleId));
        return this;
    }

    public BuilderMessageDialog setTitle(final String title) {
        mMessageDialogModel.setTitle(title);
        return this;
    }

    public BuilderMessageDialog setMessage(@StringRes int messageId) {
        mMessageDialogModel.setMessage(mContext.getText(messageId));
        return this;
    }

    public BuilderMessageDialog setMessage(final String message) {
        mMessageDialogModel.setMessage(message);
        return this;
    }

    public BuilderMessageDialog setPositiveButton(@StringRes int textId, final ButtonMessageDialogListener listener) {
        mMessageDialogModel.setPositiveText(mContext.getText(textId));
        mMessageDialogModel.setPositiveListener(listener);
        return this;
    }

    public BuilderMessageDialog setPositiveButton(CharSequence text, final ButtonMessageDialogListener listener) {
        mMessageDialogModel.setPositiveText(text);
        mMessageDialogModel.setPositiveListener(listener);
        return this;
    }

    public BuilderMessageDialog setNegativeButton(@StringRes int textId, final ButtonMessageDialogListener listener) {
        mMessageDialogModel.setNegativeText(mContext.getText(textId));
        mMessageDialogModel.setNegativeListener(listener);
        return this;
    }

    public BuilderMessageDialog setNegativeButton(CharSequence text, final ButtonMessageDialogListener listener) {
        mMessageDialogModel.setNegativeText(text);
        mMessageDialogModel.setNegativeListener(listener);
        return this;
    }

    public BuilderMessageDialog setCancelable(boolean cancelable) {
        mMessageDialogModel.setCancelable(cancelable);
        return this;
    }

    public MessageDialogFragment show() {
        MessageDialogFragment dialogFragment = MessageDialogFragment.newInstance();
        if (dialogFragment != null && dialogFragment.getDialog() != null && dialogFragment.getDialog().isShowing() && !dialogFragment.isRemoving()) {
            return null;
        }
        dialogFragment.setMessageDialogModel(mMessageDialogModel);
        dialogFragment.show(mFragmentManager, MessageDialogFragment.TAG);
        return dialogFragment;
    }
}