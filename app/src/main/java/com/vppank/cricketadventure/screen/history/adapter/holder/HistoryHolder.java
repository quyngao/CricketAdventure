package com.vppank.cricketadventure.screen.history.adapter.holder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vppank.cricketadventure.screen.user.adapter.listener.OnUserItemClickListener;

import butterknife.ButterKnife;

public class HistoryHolder extends RecyclerView.ViewHolder {

    public HistoryHolder(View itemView) {
        super(itemView);
    }

    public HistoryHolder(@LayoutRes int layoutRes, LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(layoutRes, parent, false));
        ButterKnife.bind(this, itemView);
    }
    public void render() {

    }
}
