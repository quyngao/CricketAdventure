package com.vppank.cricketadventure.screen.mission;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseFragment;
import com.vppank.cricketadventure.screen.mission.adapter.MissionAdapter;
import com.vppank.cricketadventure.screen.mission.adapter.listenner.OnMissionItemClickListenner;
import com.vppank.cricketadventure.service.api.ApiClient;
import com.vppank.cricketadventure.service.api.model.New;
import com.vppank.cricketadventure.service.api.model.NewsResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

    List<New> news;
    MissionAdapter mAdapter;

    public static NewFragment newInstance() {
        NewFragment fragment = new NewFragment();
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mission;
    }

    @Override
    protected void initView() {
        news = new ArrayList<>();

        mAdapter = new MissionAdapter(getContext(), news);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setItemClickListenner(new OnMissionItemClickListenner() {
            @Override
            public void onMissioItemClicked(New item) {

                startActivity(MissionActivity.newIntent(getContext(), item));
            }
        });


    }

    @Override
    protected void loadData() {
        showLoadingDialog();

        ApiClient.getRestInstance().getNews().enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                dissmissLoadingDialog();
                if (response.body().isSuccess()) {
                    news = response.body().getNews();
                    mAdapter.setNews(news);

                } else {
                    showMessageError(response.body().getMessage());
                }

            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                dissmissLoadingDialog();
                showMessageError("Lỗi kết nối server");

            }
        });
    }


}
