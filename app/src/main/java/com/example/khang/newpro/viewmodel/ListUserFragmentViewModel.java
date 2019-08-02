package com.example.khang.newpro.viewmodel;


import android.app.Activity;

import com.example.khang.newpro.adapter.ListUserAdapter;
import com.example.khang.newpro.base.BaseAdapter;
import com.example.khang.newpro.base.BaseViewModel;
import com.example.khang.newpro.model.User;

import java.text.DecimalFormat;
import java.util.Random;

public class ListUserFragmentViewModel extends BaseViewModel {

    private ListUserAdapter listUserAdapter;

    public ListUserAdapter getListUserAdapter() {
        return listUserAdapter;
    }

    public void setUpData(Activity activity) {
        listUserAdapter = new ListUserAdapter(activity, new BaseAdapter.OnItemClickListener() {
            @Override
            public <T> void onItemClicked(T item, int position) {
            }
        });
    }

    /**
     * Dummy 30 data
     */
    public void getListUser() {
        for (int index = 0; index < 30; index++) {
            String indexString = getNumberWithFormat(index);
            String userId = "Id" + indexString;
            String userName = "Name " + indexString;
            String numberPhone = "Phone " + indexString;

            int min = 0;
            int max = 1;
            String gender = getGender(new Random().nextInt((max - min) + 1) + min);

            String address = "Address " + indexString;
            String description = "Description " + indexString;
            listUserAdapter.addItem(new User(userId, userName, numberPhone, gender, address, description));
        }
        listUserAdapter.notifyDataSetChanged();
    }

    private String getNumberWithFormat(int number) {
        DecimalFormat formatter = new DecimalFormat("##");
        return formatter.format(number);
    }

    private String getGender(int genderIndex) {
        return genderIndex == 0 ? "Male" : "Female";
    }
}
