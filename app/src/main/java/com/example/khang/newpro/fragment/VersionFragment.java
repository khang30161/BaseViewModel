package com.example.khang.newpro.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.khang.newpro.base.BaseFragment;
import com.example.khang.newpro.databinding.FragmentVersionBinding;
import com.example.khang.newpro.viewmodel.VersionFragmentViewModel;

public class VersionFragment extends BaseFragment {

    private FragmentVersionBinding fragmentVersionBinding;
    private VersionFragmentViewModel versionFragmentViewModel;

    public VersionFragment() {
        // Required empty public constructor
    }

    public static VersionFragment newInstance() {
        VersionFragment fragment = new VersionFragment();
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
        fragmentVersionBinding = FragmentVersionBinding.inflate(inflater, container, false);
        return fragmentVersionBinding.getRoot();
    }

    @Override
    protected void setupViewModel() {
        if (versionFragmentViewModel == null) {
            versionFragmentViewModel = ViewModelProviders.of(this).get(VersionFragmentViewModel.class);
        }
        fragmentVersionBinding.setVersionViewModel(versionFragmentViewModel);
    }

    @Override
    protected void setupData() {
        versionFragmentViewModel.getVersion();
    }
}
