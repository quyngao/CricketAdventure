package com.vppank.cricketadventure.screen.social;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseFragment;
import com.vppank.cricketadventure.screen.social.adapter.FriendAdapter;
import com.vppank.cricketadventure.service.api.ApiClient;
import com.vppank.cricketadventure.service.api.model.Friend;
import com.vppank.cricketadventure.service.api.model.FriendsResponse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsFragment extends BaseFragment {

    private static final String EXTRA_TYPE_SORT = "EXTRA_TYPE_SORT";

    @BindView(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;


    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;

    List<Friend> friends;
    FriendAdapter mAdapter;

    int typeSort;

    public static FriendsFragment newInstance(int typeSort) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_TYPE_SORT, typeSort);
        FriendsFragment fragment = new FriendsFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_friends;
    }

    @Override
    protected void initView() {
        friends = new ArrayList<>();

        mAdapter = new FriendAdapter(getContext(), friends);
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
        typeSort = getArguments().getInt(EXTRA_TYPE_SORT, 0);
        refeshData();
    }

    private void refeshData() {
        mSwipeRefreshLayout.setRefreshing(true);
        ApiClient.getRestInstance().getFriends().enqueue(new Callback<FriendsResponse>() {
            @Override
            public void onResponse(Call<FriendsResponse> call, Response<FriendsResponse> response) {
                mSwipeRefreshLayout.setRefreshing(false);
                if (response.body().isSuccess()) {
                    friends = response.body().getFriends();
                    sortFriends();
                    mAdapter.setFriends(friends);
                } else {
                    showMessageError(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<FriendsResponse> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
                showMessageError("Lỗi kết nối server");
            }
        });
    }

    private void sortFriends() {
        Comparator<Friend> comparator = new Comparator<Friend>() {
            @Override
            public int compare(Friend left, Friend right) {
                return typeSort == 0 ? left.getTotalTravel() - right.getTotalTravel() : left.getTotalWeed() - right.getTotalWeed() ;
            }
        };
        Collections.sort(friends, comparator);

    }
}
