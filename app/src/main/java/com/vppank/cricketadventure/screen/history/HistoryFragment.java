package com.vppank.cricketadventure.screen.history;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.app.CricketApplication;
import com.vppank.cricketadventure.screen.common.BaseFragment;
import com.vppank.cricketadventure.screen.history.adapter.HistoryAdapter;
import com.vppank.cricketadventure.screen.home.HomeFragment;
import com.vppank.cricketadventure.service.api.ApiClient;
import com.vppank.cricketadventure.service.api.model.Transation;
import com.vppank.cricketadventure.service.api.model.TransationsResonse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HistoryFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

    @BindView(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;

    List<Transation> transations;
    HistoryAdapter mAdapter;

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_history;
    }

    @Override
    protected void initView() {
        transations = new ArrayList<>();

        mAdapter = new HistoryAdapter(getContext(), transations);
        GridLayoutManager mLayoutManager = new GridLayoutManager(getContext(), 1);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refeshData();
            }
        });

        mSwipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        mSwipeRefreshLayout.setDistanceToTriggerSync(14);// in dips
        mSwipeRefreshLayout.setSize(SwipeRefreshLayout.LARGE);// LARGE also can be used
    }

    @Override
    protected void loadData() {
        refeshData();
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    private void refeshData() {
        mSwipeRefreshLayout.setRefreshing(true);
        ApiClient.getRestInstance().getAllTransation().enqueue(new Callback<TransationsResonse>() {
            @Override
            public void onResponse(Call<TransationsResonse> call, Response<TransationsResonse> response) {
                mSwipeRefreshLayout.setRefreshing(false);
                if (response.body().isSuccess()) {
                    transations = response.body().getTransations();
                    mAdapter.setTransations(transations);
                } else {
                    showMessageError(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<TransationsResonse> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);

                showMessageError("Lỗi kết nối server");
            }
        });
    }
}
