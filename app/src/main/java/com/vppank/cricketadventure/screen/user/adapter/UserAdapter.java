package com.vppank.cricketadventure.screen.user.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.user.adapter.holder.UserHolder;
import com.vppank.cricketadventure.screen.user.adapter.listener.OnUserItemClickListener;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserHolder> {

    OnUserItemClickListener itemClickListener;
    private LayoutInflater mInflater;


    public UserAdapter(Context mContext, List<Integer> userList) {
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public UserHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new UserHolder(R.layout.item_user, mInflater, parent);
    }

    @Override
    public void onBindViewHolder(UserHolder holder, int position) {
        holder.setItemClickListener(itemClickListener);
        holder.render();

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
