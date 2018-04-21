package com.vppank.cricketadventure.screen.home;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseFragment;

public class HomeFragment extends BaseFragment {
    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void loadData() {
    }
}
