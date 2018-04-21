package com.vppank.cricketadventure.screen.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.widget.ProgressBar;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseActivity;
import com.vppank.cricketadventure.screen.main.MainActivity;
import com.vppank.cricketadventure.screen.shopping.ShoppingActivity;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {


    @BindView(R.id.loading)
    protected ProgressBar mLoading;

    @Override
    protected int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(MainActivity.newIntent(SplashActivity.this));
                finish();
            }
        }, 1000);
    }
}
