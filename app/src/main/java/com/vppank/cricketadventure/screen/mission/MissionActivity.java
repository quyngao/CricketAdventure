package com.vppank.cricketadventure.screen.mission;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.helper.Utils;
import com.vppank.cricketadventure.screen.announce.adapter.AnnouncementPagerAdapter;
import com.vppank.cricketadventure.screen.common.BaseActivity;
import com.vppank.cricketadventure.screen.mission.adapter.SlidePagerAdapter;
import com.vppank.cricketadventure.service.api.ApiClient;
import com.vppank.cricketadventure.service.api.model.New;
import com.vppank.cricketadventure.service.api.model.UserResponse;

import butterknife.BindView;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MissionActivity extends BaseActivity {


    private static final String EXTRA_NEW = "EXTRA_NEW";


    public static Intent newIntent(Context context, New aNew) {
        Intent intent = new Intent(context, MissionActivity.class);
        intent.putExtra(EXTRA_NEW, aNew);
        return intent;
    }


    @BindView(R.id.view_pager)
    protected ViewPager mViewPager;


    @BindView(R.id.btn_skip)
    protected Button skip;

    @BindView(R.id.btn_next)
    protected Button next;

    @BindView(R.id.layoutDots)
    protected LinearLayout dotsLayout;

    private TextView[] dots;

    New aNew;

    @Override
    protected int getLayout() {
        return R.layout.activity_mission;
    }

    @Override
    protected void initView() {

        aNew = (New) getIntent().getSerializableExtra(EXTRA_NEW);
        if (aNew == null) finish();
        setupViewPager();
    }

    private void setupViewPager() {
        SlidePagerAdapter adapter = new SlidePagerAdapter(getSupportFragmentManager());
        adapter.addFragments(aNew.getImages());
        mViewPager.setAdapter(adapter);
        addBottomDots(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                addBottomDots(position);
                if (position == aNew.getImages().size() - 1) {
                    next.setText(getString(R.string.start));
                    skip.setVisibility(View.GONE);
                } else {
                    next.setText(getString(R.string.next));
                    skip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[aNew.getImages().size()];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }


    @OnClick(R.id.btn_skip)
    public void onSkipClicked() {
        finish();
    }

    @OnClick(R.id.btn_next)
    public void onNextClicked() {
        int current = getItem(+1);
        if (current < aNew.getImages().size()) {
            // move to next screen
            mViewPager.setCurrentItem(current);
        } else {
            if (aNew.isRead()) {
                finish();
            } else
                readNews(aNew.getId());
        }

    }

    private void readNews(String id) {
        showLoadingDialog();
        ApiClient.getRestInstance().readNew(id).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                dissmissLoadingDialog();
                if (response.body().isSuccess()) {
                    Utils.newBuilderAlertDialog(MissionActivity.this)
                            .setTitle("Hoàn thành nhiệm vụ")
                            .setMessage(String.format("Bạn đã nhận được thêm 10%s",getString(R.string.grass)))
                            .setPositiveButton("Đóng", null)
                            .setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialogInterface) {
                                    finish();
                                }
                            })
                            .show();
                } else {
                    dissmissLoadingDialog();
                    showMessageError(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                dissmissLoadingDialog();
                showMessageError("Lỗi kết nối server");
            }
        });
    }

    private int getItem(int i) {
        return mViewPager.getCurrentItem() + i;
    }


}
