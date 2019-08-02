package com.example.khang.newpro.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.khang.newpro.base.BaseFragment;
import com.example.khang.newpro.databinding.FragmentListUserBinding;
import com.example.khang.newpro.viewmodel.ListUserFragmentViewModel;

public class ListUserFragment extends BaseFragment {

    private FragmentListUserBinding fragmentListUserBinding;
    private ListUserFragmentViewModel listUserFragmentViewModel;

    public ListUserFragment() {
        // Required empty public constructor
    }

    public static ListUserFragment newInstance() {
        ListUserFragment fragment = new ListUserFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            //get param to do
        }
    }

    @Override
    protected View bindView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container) {
        fragmentListUserBinding = FragmentListUserBinding.inflate(inflater, container, false);
        return fragmentListUserBinding.getRoot();
    }

    @Override
    protected void setupViewModel() {
        if (listUserFragmentViewModel == null) {
            listUserFragmentViewModel = ViewModelProviders.of(this).get(ListUserFragmentViewModel.class);
        }
        fragmentListUserBinding.setListUserViewModel(listUserFragmentViewModel);
    }

    @Override
    protected void setupData() {
        listUserFragmentViewModel.setUpData(getActivity());
        listUserFragmentViewModel.getListUser();
        fragmentListUserBinding.tvFmListUserTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "asdasd", Toast.LENGTH_LONG).show();
                listUserFragmentViewModel.getListUserAdapter().notifyDataSetChanged();
            }
        });
    }
}
