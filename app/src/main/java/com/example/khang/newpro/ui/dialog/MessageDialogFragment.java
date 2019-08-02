package com.example.khang.newpro.ui.dialog;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khang.newpro.base.BaseDialogFragment;
import com.example.khang.newpro.databinding.DialogMessageBinding;
import com.example.khang.newpro.data.model.MessageDialogModel;
import com.example.khang.newpro.viewmodel.dialog.MessageDialogViewModel;

public class MessageDialogFragment extends BaseDialogFragment {
    public static final String TAG = MessageDialogFragment.class.getSimpleName();

    private MessageDialogViewModel messageDialogViewModel;
    private DialogMessageBinding dialogMessageBinding;

    private MessageDialogModel mMessageDialogModel;

    private static MessageDialogFragment messageDialogFragment;

    public MessageDialogFragment() {
        // Required empty public constructor
    }

    public static MessageDialogFragment newInstance() {
        if (messageDialogFragment == null) {
            messageDialogFragment = new MessageDialogFragment();
            Bundle args = new Bundle();
            messageDialogFragment.setArguments(args);
        }
        return messageDialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    protected View bindView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        dialogMessageBinding = DialogMessageBinding.inflate(inflater, container, false);
        return dialogMessageBinding.getRoot();
    }

    @Override
    protected void setupData() {
        messageDialogViewModel.setupModel(this, mMessageDialogModel);
        messageDialogViewModel.getPositiveEvent().observe(this, voidEvent -> {
            if (messageDialogViewModel.getPositiveListener() != null) {
                messageDialogViewModel.getPositiveListener().onClick(this);
            }
        });
        messageDialogViewModel.getNegativeEvent().observe(this, voidEvent -> {
            if (messageDialogViewModel.getNegativeListener() != null) {
                messageDialogViewModel.getNegativeListener().onClick(this);
            }
        });
    }

    @Override
    protected void setupViewModel() {
        if (messageDialogViewModel == null) {
            messageDialogViewModel = ViewModelProviders.of(this).get(MessageDialogViewModel.class);
        }
        //set up viewmodel live data
        dialogMessageBinding.setMessageDialogViewModel(messageDialogViewModel);
    }

    public void setMessageDialogModel(MessageDialogModel messageDialogModel) {
        this.mMessageDialogModel = messageDialogModel;
    }
}
