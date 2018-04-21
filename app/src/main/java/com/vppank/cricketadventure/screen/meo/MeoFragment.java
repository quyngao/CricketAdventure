package com.vppank.cricketadventure.screen.meo;

import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseFragment;
import com.vppank.cricketadventure.screen.history.HistoryFragment;
import com.vppank.cricketadventure.screen.meo.dialog.BaloDialogFragment;
import com.vppank.cricketadventure.screen.meo.dialog.MailDialogFragment;
import com.vppank.cricketadventure.screen.meo.dialog.ShopFragmentDialog;
import com.vppank.cricketadventure.storage.share.UserInfo;

import java.util.ArrayList;
import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;

public class MeoFragment extends BaseFragment {

    int [] TREN = { R.drawable.meo_ngu, R.drawable.meo_choi };
    int [] DUOI = { R.drawable.meo_ngoi_nghieng, R.drawable.meo_doc_sach };

    Resources r;

    @BindView(R.id.imgMeo)
    ImageView imgMeo;

    @OnClick(R.id.btnShop)
    public void onShopClicked(View v){
        ShopFragmentDialog shopDialog = ShopFragmentDialog.newInstance(new ShopFragmentDialog.OnBoughtItemListener() {
            @Override
            public void onBoughtItem(int code) {
                UserInfo.getInstance().getUser().getItems().add(code);
                Log.e("Ban vua mua", ShopFragmentDialog.LIST_ITEMS.get(code).getName());
            }
        });
        shopDialog.setCancelable(true);
        shopDialog.show(getActivity().getSupportFragmentManager(), "shopDialog");
    }

    @OnClick(R.id.btnBalo)
    public void onBaloClicked(View v){
        BaloDialogFragment baloDialog = BaloDialogFragment.newInstance();//where MyFragment is my fragment I want to show
        baloDialog.setCancelable(true);
        baloDialog.show(getActivity().getSupportFragmentManager(), "baloDialog");
    }

    @OnClick(R.id.btnMail)
    public void onMailClicked(View v){
        MailDialogFragment mailDialogFragment = MailDialogFragment.newInstance();
        mailDialogFragment.setCancelable(true);
        mailDialogFragment.show(getActivity().getSupportFragmentManager(), "mailDialog");
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
        r = getResources();
        initMeo();
    }

    private void initMeo() {
        Random random = new Random();
        int status = random.nextInt(2);
        int rd2 = random.nextInt(2);

        if (status == 0) {//o duoi

            int marginTop = dpToPixcel(R.dimen._215sdp);
            int marginRight = dpToPixcel(R.dimen._5sdp);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imgMeo.getLayoutParams();
            params.setMargins(0, marginTop, marginRight, 0);
            imgMeo.setLayoutParams(params);
            imgMeo.setImageDrawable(getActivity().getDrawable(DUOI[rd2]));

        } else { //o tren
            int marginTop = dpToPixcel(R.dimen._75sdp);
            int marginRight = dpToPixcel(R.dimen._50sdp);
            RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) imgMeo.getLayoutParams();
            params.setMargins(0, marginTop, marginRight, 0);
            imgMeo.setLayoutParams(params);
            imgMeo.setImageDrawable(getActivity().getDrawable(TREN[rd2]));
        }
    }

    private int dpToPixcel(int dp){
        return (int) getResources().getDimension(dp);
        //return (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, getResources().getDimension(dp), r.getDisplayMetrics());
    }

    @Override
    protected void loadData() {

    }
}
