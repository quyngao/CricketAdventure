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

    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public SocialPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments() {
        Fragment fragment = FriendsFragment.newInstance(0);
        mFragments.add(fragment);
        mFragmentTitles.add("Thông thái");

        Fragment fragment2 = FriendsFragment.newInstance(1);
        mFragments.add(fragment2);
        mFragmentTitles.add("Béo");

        Fragment fragment3 = FriendsFragment.newInstance(0);
        mFragments.add(fragment3);
        mFragmentTitles.add("Chăm chỉ");
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

