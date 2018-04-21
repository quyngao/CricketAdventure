package com.vppank.cricketadventure.screen.notification;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseFragment;
import com.vppank.cricketadventure.screen.history.HistoryFragment;
import com.vppank.cricketadventure.screen.history.adapter.HistoryAdapter;
import com.vppank.cricketadventure.screen.notification.adapter.NotificationAdapter;
import com.vppank.cricketadventure.screen.social.SocialFragment;
import com.vppank.cricketadventure.service.api.ApiClient;
import com.vppank.cricketadventure.service.api.model.Notification;
import com.vppank.cricketadventure.service.api.model.NotificationsResponse;
import com.vppank.cricketadventure.service.api.model.Transation;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationFragment extends BaseFragment {

    @BindView(R.id.swipeRefreshLayout)
    protected SwipeRefreshLayout mSwipeRefreshLayout;


    @BindView(R.id.recycler_view)
    protected RecyclerView mRecyclerView;


    List<Notification> notifications;
    NotificationAdapter mAdapter;

    public static NotificationFragment newInstance() {
        NotificationFragment fragment = new NotificationFragment();
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_notification;
    }

    @Override
    protected void initView() {
        notifications = new ArrayList<>();

        mAdapter = new NotificationAdapter(getContext(), notifications);
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

    private void refeshData() {
        mSwipeRefreshLayout.setRefreshing(true);
        ApiClient.getRestInstance().getNotifications().enqueue(new Callback<NotificationsResponse>() {
            @Override
            public void onResponse(Call<NotificationsResponse> call, Response<NotificationsResponse> response) {
                mSwipeRefreshLayout.setRefreshing(false);
                if (response.body().isSuccess()) {
                    notifications = response.body().getNotifications();
                    mAdapter.setNotifications(notifications);
                } else {
                    showMessageError(response.body().getMessage());
                }
            }

            @Override
            public void onFailure(Call<NotificationsResponse> call, Throwable t) {
                mSwipeRefreshLayout.setRefreshing(false);
                showMessageError("Lỗi kết nối server");
            }
        });

    }

}
