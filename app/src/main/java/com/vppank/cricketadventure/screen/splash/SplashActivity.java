package com.vppank.cricketadventure.screen.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.ProgressBar;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.app.CricketApplication;
import com.vppank.cricketadventure.screen.common.BaseActivity;
import com.vppank.cricketadventure.screen.login.LoginActivity;
import com.vppank.cricketadventure.screen.main.MainActivity;
import com.vppank.cricketadventure.screen.shopping.ShoppingActivity;
import com.vppank.cricketadventure.service.api.model.User;
import com.vppank.cricketadventure.storage.share.UserInfo;

import butterknife.BindView;

public class SplashActivity extends BaseActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

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
    protected void loadData() {
        super.loadData();
        String authen = CricketApplication.getPrefManager().getAuth();
        User user = CricketApplication.getPrefManager().getUser();
        if (TextUtils.isEmpty(authen)) {
            nextScreen(LoginActivity.class);
        } else {
            UserInfo.getInstance().setAccessToken(authen);
            UserInfo.getInstance().setUser(user);
            nextScreen(MainActivity.class);
        }
    }

    public void nextScreen(Class activity) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(LoginActivity.newIntent(SplashActivity.this));
                finish();
            }
        }, 1000);

    }
}
