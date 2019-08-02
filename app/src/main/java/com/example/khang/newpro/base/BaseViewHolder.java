package com.example.khang.newpro.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public BaseViewHolder(View paramView) {
        super(paramView);
//        FontsManager.changeFonts(paramView);
    }
}