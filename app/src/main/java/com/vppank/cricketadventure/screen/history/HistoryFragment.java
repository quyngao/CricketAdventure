package com.vppank.cricketadventure.screen.history;

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
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onResume() {
        super.onResume();
        refeshData();
    }

    private void refeshData() {
        showLoadingDialog();
        ApiClient.getRestInstance().getAllTransation().enqueue(new Callback<TransationsResonse>() {
            @Override
            public void onResponse(Call<TransationsResonse> call, Response<TransationsResonse> response) {
                dissmissLoadingDialog();
                if (response.body().isSuccess()) {
                    transations = response.body().getTransations();
                    mAdapter.setTransations(transations);
                } else {
                    showMessageError(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<TransationsResonse> call, Throwable t) {
                dissmissLoadingDialog();
                showMessageError("Lỗi kết nối server");
            }
        });
    }
}
