package com.example.khang.newpro.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.example.khang.newpro.R;
import com.rey.material.widget.ProgressView;

public class MyProgressDialog extends ProgressDialog {
    public MyProgressDialog(Context context) {
        super(context);
    }

    public MyProgressDialog(Context context, int theme) {
        super(context, theme);
    }

    private ProgressView dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_view_base);
        dialog = findViewById(R.id.progress_view_base);
    }

    public void showLoading() {
        if (dialog != null) {
            dialog.start();
        }
    }

    public void closeLoading() {
        if (dialog != null) {
            if (dialog.isShown()) {
                dialog.stop();
            }
        }
    }
}

