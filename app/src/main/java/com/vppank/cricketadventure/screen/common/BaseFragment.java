package com.vppank.cricketadventure.screen.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import com.vppank.cricketadventure.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by QUYLE on 3/4/18.
 */

public abstract class BaseFragment extends Fragment {
    @BindView(R.id.root)
    View mRootView;


    ProgressDialog dialog;

    protected abstract int getLayout();

    protected abstract void initView();

    protected abstract void loadData();

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, root);
        initView();

        return root;
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    protected void showMessageError(String message) {
        Snackbar snackbar = Snackbar
                .make(mRootView, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    protected void showLoadingDialog() {
        dialog = new ProgressDialog(getContext());
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

    public void hideKeyBoard() {
        View view = getActivity().getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
