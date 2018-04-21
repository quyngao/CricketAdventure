package com.vppank.cricketadventure.screen.shopping;

import android.content.Context;
import android.content.Intent;

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

    }
}
