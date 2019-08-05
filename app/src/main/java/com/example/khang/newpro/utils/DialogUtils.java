package com.example.khang.newpro.utils;

import android.app.ProgressDialog;
import android.content.Context;

import com.example.khang.newpro.R;

public class DialogUtils {
    private static MyProgressDialog progress;

    public static void showLoadingProgress(Context context, boolean isCancel) {
        try {
            if (progress == null) {
                progress = new MyProgressDialog(context, R.style.dialog_full_transparent_background);
                progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progress.setIndeterminate(true);
                progress.setCancelable(isCancel);
            }
            if (progress != null) {
                if (!progress.isShowing()) {
                    progress.show();
                    progress.showLoading();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void hideLoadingProgress() {
        try {
            if (progress != null) {
                progress.closeLoading();
                progress.dismiss();
                progress = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
