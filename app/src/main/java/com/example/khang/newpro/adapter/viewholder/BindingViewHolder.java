package com.example.khang.newpro.adapter.viewholder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

public class BindingViewHolder extends RecyclerView.ViewHolder {

    private ViewDataBinding binding;

    public ViewDataBinding getBinding() {
        return binding;
    }

    public BindingViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
