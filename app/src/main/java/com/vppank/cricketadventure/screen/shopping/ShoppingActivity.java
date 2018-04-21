package com.vppank.cricketadventure.screen.shopping;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseActivity;
import com.vppank.cricketadventure.screen.item.ItemActivity;

public class ShoppingActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ShoppingActivity.class);
        return intent;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_shopping;
    }

    @Override
    protected void initView() {
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

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
}
