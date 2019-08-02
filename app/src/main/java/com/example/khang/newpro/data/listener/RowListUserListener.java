package com.example.khang.newpro.data.listener;

import com.example.khang.newpro.data.model.User;

public interface RowListUserListener {
    void onDeleteClick(User user);

    void onShowAllClick(User user);
}
