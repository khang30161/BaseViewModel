package com.example.khang.newpro.viewmodel.adapter.viewmodel;

import com.example.khang.newpro.base.BaseViewModel;
import com.example.khang.newpro.data.model.User;

public class ListUserItemViewModel extends BaseViewModel {
    private User user;

    public User getUser() {
        return this.user;
    }

    public ListUserItemViewModel(User user) {
        this.user = user;
    }
}
