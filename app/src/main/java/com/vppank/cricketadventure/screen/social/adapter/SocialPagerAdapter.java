package com.vppank.cricketadventure.screen.social.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vppank.cricketadventure.screen.history.HistoryFragment;
import com.vppank.cricketadventure.screen.notification.NotificationFragment;
import com.vppank.cricketadventure.screen.social.FriendsFragment;
import com.vppank.cricketadventure.service.api.model.Friend;

import java.util.ArrayList;
import java.util.List;

public class SocialPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mFragmentTitles = new ArrayList<>();

    public SocialPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments() {

        mFragments = new ArrayList<>();
        mFragments.add(FriendsFragment.newInstance(0));
        mFragmentTitles.add("Thông thái");
        mFragments.add(FriendsFragment.newInstance(1));
        mFragmentTitles.add("Béo");

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

