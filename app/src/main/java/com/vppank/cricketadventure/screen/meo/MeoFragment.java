package com.vppank.cricketadventure.screen.meo;

import android.util.Log;
import android.view.View;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseFragment;
import com.vppank.cricketadventure.screen.history.HistoryFragment;
import com.vppank.cricketadventure.screen.meo.dialog.ShopFragmentDialog;

import butterknife.OnClick;

public class MeoFragment extends BaseFragment {

    @OnClick(R.id.btnShop)
    public void onShopClicked(View v){
        ShopFragmentDialog shopDialog = ShopFragmentDialog.newInstance(new ShopFragmentDialog.OnBoughtItemListener() {
            @Override
            public void onBoughtItem(int code) {
                Log.e("Ban vua mua", ShopFragmentDialog.LIST_ITEMS.get(code).getName());
            }
        }); //where MyFragment is my fragment I want to show
        shopDialog.setCancelable(true);
        shopDialog.show(getActivity().getSupportFragmentManager(), "shopDialog");
    }


    public static MeoFragment newInstance() {
        MeoFragment fragment = new MeoFragment();
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_meo;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void loadData() {

    }
}
