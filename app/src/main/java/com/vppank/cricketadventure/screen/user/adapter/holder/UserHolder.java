package com.vppank.cricketadventure.screen.user.adapter.holder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vppank.cricketadventure.screen.user.adapter.listener.OnUserItemClickListener;

import butterknife.ButterKnife;

public class UserHolder extends RecyclerView.ViewHolder {


    OnUserItemClickListener itemClickListener;


    public UserHolder(View itemView) {
        super(itemView);
    }

    public UserHolder(@LayoutRes int layoutRes, LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(layoutRes, parent, false));
        ButterKnife.bind(this, itemView);
    }

    public void setItemClickListener(OnUserItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void render() {

    }
}
