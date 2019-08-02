package com.example.khang.newpro.viewmodel;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.example.khang.newpro.R;
import com.example.khang.newpro.base.BaseActivity;
import com.example.khang.newpro.base.BaseViewModel;
import com.example.khang.newpro.enums.DetailType;
import com.example.khang.newpro.enums.ExtraKeyType;
import com.example.khang.newpro.fragment.ListUserFragment;
import com.example.khang.newpro.fragment.VersionFragment;

public class DetailViewModel extends BaseViewModel {

    public void replaceFragments(BaseActivity activity) {
        DetailType type = DetailType.detachFrom(activity.getIntent());
        Bundle bundleExtra = activity.getIntent().getBundleExtra(ExtraKeyType.DEFAULT_EXTRA.getValue());
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
        switch (type) {
            case VERSION_APP_DETAIL: {
//                String userId = (getIntent().getExtras().getString(Constants.EXTRA_USER_ID));
                fragmentTransaction.replace(R.id.fl_container, VersionFragment.newInstance()).commitAllowingStateLoss();
                break;
            }
            case LIST_USER_DETAIL: {
                fragmentTransaction.replace(R.id.fl_container, ListUserFragment.newInstance()).commitAllowingStateLoss();
                break;
            }

            default: {

                break;
            }
        }
    }
}
