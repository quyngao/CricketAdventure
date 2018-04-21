package com.vppank.cricketadventure.screen.item;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseActivity;
import com.vppank.cricketadventure.screen.item.adapter.ItemPagerAdapter;

import butterknife.BindView;

public class ItemActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    protected Toolbar mToolbar;

    @BindView(R.id.tabs)
    protected TabLayout mTableLayout;

    @BindView(R.id.viewpager)
    protected ViewPager mViewPager;

    ActionBar ab;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ItemActivity.class);
//        intent.putExtra(EXTRA_CUSTOMER_ID, user.getId());
        return intent;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_item;
    }

    @Override
    protected void initView() {
        setSupportActionBar(mToolbar);

        ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        setupViewPager();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setupViewPager() {
        ItemPagerAdapter adapter = new ItemPagerAdapter(getSupportFragmentManager());
        adapter.addFragments(3);
        mViewPager.setAdapter(adapter);
        mTableLayout.setupWithViewPager(mViewPager);
    }

}
