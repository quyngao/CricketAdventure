package com.vppank.cricketadventure.screen.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vppank.cricketadventure.screen.history.HistoryFragment;
import com.vppank.cricketadventure.screen.notification.NotificationFragment;

import java.util.ArrayList;
import java.util.List;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }
}
