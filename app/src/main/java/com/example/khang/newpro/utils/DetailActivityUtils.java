package com.example.khang.newpro.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.example.khang.newpro.activity.DetailActivity;
import com.example.khang.newpro.enums.DetailType;
import com.example.khang.newpro.enums.ExtraKeyType;

public class DetailActivityUtils {
    public static void startDetailActivity(Activity activity, DetailType detailType, Bundle bundle, boolean isReturnDataToActivity, Integer requestCode) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(ExtraKeyType.DEFAULT_EXTRA.getValue(), bundle);
        detailType.attachTo(intent);
        if (isReturnDataToActivity) {
            activity.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivity(intent);
        }
    }
}
