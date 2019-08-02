package com.example.khang.newpro.data.enums;

import android.content.Intent;

public enum DetailType {
    VERSION_APP_DETAIL,
    LIST_USER_DETAIL;

    private static final String name = DetailType.class.getName();

    public void attachTo(Intent intent) {
        intent.putExtra(name, ordinal());
    }

    public static DetailType detachFrom(Intent intent) {
        if (!intent.hasExtra(name)) throw new IllegalStateException();
        return values()[intent.getIntExtra(name, -1)];
    }
}
