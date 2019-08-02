package com.example.khang.newpro.viewmodel;


import android.app.Activity;
import android.os.Handler;

import com.example.khang.newpro.adapter.ListUserAdapter;
import com.example.khang.newpro.base.BaseAdapter;
import com.example.khang.newpro.base.BaseViewModel;
import com.example.khang.newpro.base.SingleLiveEvent;
import com.example.khang.newpro.model.User;

import java.text.DecimalFormat;
import java.util.Random;

public class ListUserFragmentViewModel extends BaseViewModel {

    private SingleLiveEvent<Void> mEndClearDataEvent = new SingleLiveEvent<>();

    private ListUserAdapter listUserAdapter;
    private int currentIndex;
    private boolean isMoreLoading;

    public ListUserAdapter getListUserAdapter() {
        return listUserAdapter;
    }

    public SingleLiveEvent<Void> getEndClearDataEvent() {
        return mEndClearDataEvent;
    }

    public void setUpData(Activity activity) {
        listUserAdapter = new ListUserAdapter(activity, new BaseAdapter.OnItemClickListener() {
            @Override
            public <T> void onItemClicked(T item, int position) {
            }
        });
    }

    public void checkLoadMoreData(int dy, int lastCompletelyVisibleItemPosition) {
        if (dy > 0) {
            if (!isMoreLoading) {
                if (lastCompletelyVisibleItemPosition == listUserAdapter.getItemCount() - 1) {
                    //bottom of list!
                    listUserAdapter.addItem(null);
                    isMoreLoading = true;

                    //Add dummy data and delay 2s
                    currentIndex += 30;
                    Handler handler = new Handler();
                    handler.postDelayed(() -> getListUser(), 2000);
                }
            }
        }
    }

    /**
     * Hide Load More After Load Data Done
     */
    private void hideLoadMore() {
        if (isMoreLoading && listUserAdapter.getItemCount() > 0) {
            listUserAdapter.removeItem(listUserAdapter.getItemCount() - 1);
            isMoreLoading = false;
        }
    }

    /**
     * Clear All Data And Call Back To Activity Stop SwipeRefreshLayout
     */
    public void refresh() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            listUserAdapter.clearAllItems();
            currentIndex = 0;
            getListUser();
            mEndClearDataEvent.call();
        }, 2000);
    }

    /**
     * Dummy 30 data
     */
    public void getListUser() {
        hideLoadMore();
        for (int index = currentIndex; index < currentIndex + 30; index++) {
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
