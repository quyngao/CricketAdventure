package com.vppank.cricketadventure.screen.social.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.notification.adapter.holder.NotificationHolder;
import com.vppank.cricketadventure.screen.social.adapter.holder.FriendHolder;
import com.vppank.cricketadventure.service.api.model.Friend;
import com.vppank.cricketadventure.service.api.model.Notification;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendHolder> {

    private LayoutInflater mInflater;

    private List<Friend> friends;


    public FriendAdapter(Context mContext, List<Friend> friends) {
        mInflater = LayoutInflater.from(mContext);
        this.friends = friends;
    }

    @Override
    public FriendHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FriendHolder(R.layout.item_friend, mInflater, parent);

    }

    @Override
    public void onBindViewHolder(FriendHolder holder, int position) {
        Friend friend = friends.get(position);
        holder.render(friend);
    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
        notifyDataSetChanged();
    }
}
