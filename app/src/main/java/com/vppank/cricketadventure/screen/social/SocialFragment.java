package com.vppank.cricketadventure.screen.social;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.announce.adapter.AnnouncementPagerAdapter;
import com.vppank.cricketadventure.screen.common.BaseFragment;
import com.vppank.cricketadventure.screen.history.HistoryFragment;
import com.vppank.cricketadventure.screen.social.adapter.SocialPagerAdapter;

import butterknife.BindView;

public class SocialFragment extends BaseFragment {

    @BindView(R.id.tabs)
    protected TabLayout mTableLayout;

    @BindView(R.id.viewpager)
    protected ViewPager mViewPager;

    public static SocialFragment newInstance() {
        SocialFragment fragment = new SocialFragment();
        return fragment;
    }
    @Override
    protected int getLayout() {
        return R.layout.fragment_social;
    }

    @Override
    protected void initView() {
        setupViewPager();
    }

    @Override
    protected void loadData() {

    }

    private void setupViewPager() {
        SocialPagerAdapter adapter = new SocialPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragments();
        mViewPager.setAdapter(adapter);
        mTableLayout.setupWithViewPager(mViewPager);
    }
}
