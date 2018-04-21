package com.vppank.cricketadventure.screen.announce;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.announce.adapter.AnnouncementPagerAdapter;
import com.vppank.cricketadventure.screen.common.BaseFragment;

import butterknife.BindView;

public class AnnouncemetFragment extends BaseFragment {

    @BindView(R.id.tabs)
    protected TabLayout mTableLayout;

    @BindView(R.id.viewpager)
    protected ViewPager mViewPager;

    @Override
    protected int getLayout() {
        return R.layout.fragment_annoucement;
    }

    @Override
    protected void initView() {
        setupViewPager();
    }

    private void setupViewPager() {
        AnnouncementPagerAdapter adapter = new AnnouncementPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragments();
        mViewPager.setAdapter(adapter);
        mTableLayout.setupWithViewPager(mViewPager);
    }

    @Override
    protected void loadData() {

    }
}
