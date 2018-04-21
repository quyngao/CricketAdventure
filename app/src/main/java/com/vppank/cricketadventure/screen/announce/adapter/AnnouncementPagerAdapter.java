package com.vppank.cricketadventure.screen.announce.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vppank.cricketadventure.screen.history.HistoryFragment;
import com.vppank.cricketadventure.screen.home.HomeFragment;
import com.vppank.cricketadventure.screen.mission.NewFragment;
import com.vppank.cricketadventure.screen.notification.NotificationFragment;
import com.vppank.cricketadventure.service.api.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public AnnouncementPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments() {
        Fragment fragment = HistoryFragment.newInstance();
        mFragments.add(fragment);
        mFragmentTitles.add("Giao dịch");

        Fragment fragment2 = NotificationFragment.newInstance();
        mFragments.add(fragment2);
        mFragmentTitles.add("Thông báo");
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

