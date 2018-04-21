package com.vppank.cricketadventure.screen.mission.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vppank.cricketadventure.screen.mission.SlideFragment;

import java.util.ArrayList;
import java.util.List;

public class SlidePagerAdapter
        extends FragmentPagerAdapter {


    private final List<SlideFragment> mFragments = new ArrayList<>();

    public SlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragments(List<String> images) {
        for (int i = 0; i < images.size(); i++) {
            SlideFragment fragment = SlideFragment.newInstance(images.get(i));
            mFragments.add(fragment);
        }

    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


}
