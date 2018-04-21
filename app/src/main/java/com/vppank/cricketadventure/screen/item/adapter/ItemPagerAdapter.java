package com.vppank.cricketadventure.screen.item.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vppank.cricketadventure.screen.home.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class ItemPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragments = new ArrayList<>();
    private final List<String> mFragmentTitles = new ArrayList<>();

    public ItemPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments(int id) {
        Fragment fragment = HomeFragment.newInstance();
        mFragments.add(fragment);
        mFragmentTitles.add("Home");

        fragment = HomeFragment.newInstance();
        mFragments.add(fragment);
        mFragmentTitles.add("Notification");

        fragment = HomeFragment.newInstance();
        mFragments.add(fragment);
        mFragmentTitles.add("Play");
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

