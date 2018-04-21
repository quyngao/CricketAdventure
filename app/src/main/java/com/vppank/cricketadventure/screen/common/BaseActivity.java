package com.vppank.cricketadventure.screen.common;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.helper.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by QUYLE on 3/4/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }

    @BindView(R.id.root)
    protected View mRootView;

    ProgressDialog dialog;

    protected abstract int getLayout();

    protected abstract void initView();

    protected void loadData() {
        if (!Utils.isConnected()) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    showMessageErrorWithAction(getString(R.string.no_internet_connection));
                }
            }, 500);
        }
        return;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);
        initView();
        loadData();

    }

    public void replaceFragment(Fragment fragment, int containerId, String tag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(containerId, fragment, tag);
        ft.commit();
    }

    protected void showMessageError(String message) {
        Snackbar snackbar = Snackbar
                .make(mRootView, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    protected void showMessageErrorWithAction(String message) {
        Snackbar snackbar = Snackbar
                .make(mRootView, message, Snackbar.LENGTH_LONG)
                .setAction("Setting", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    }
                });
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }

    protected void showLoadingDialog() {
        dialog = new ProgressDialog(this);
        dialog.setTitle("");
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);
        dialog.show();

    }

    protected void dissmissLoadingDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
        dialog = null;
    }




}
