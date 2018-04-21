package com.vppank.cricketadventure.screen.mission;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseFragment;
import com.vppank.cricketadventure.screen.social.FriendsFragment;

import butterknife.BindView;

public class SlideFragment extends BaseFragment {
    private static final String EXTRA_IMAGE = "EXTRA_IMAGE";

    @BindView(R.id.image)
    protected ImageView imageView;

    public static SlideFragment newInstance(String images) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_IMAGE, images);
        SlideFragment fragment = new SlideFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_slide;
    }

    @Override
    protected void initView() {
        String message = getArguments().getString(EXTRA_IMAGE, "");
        if (TextUtils.isEmpty(message)) {
            return;
        }
        Picasso.get().load(message).into(imageView);
    }

    @Override
    protected void loadData() {

    }
}
