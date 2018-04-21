package com.vppank.cricketadventure.screen.history.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.history.adapter.holder.HistoryHolder;
import com.vppank.cricketadventure.screen.user.adapter.holder.UserHolder;
import com.vppank.cricketadventure.screen.user.adapter.listener.OnUserItemClickListener;
import com.vppank.cricketadventure.service.api.model.Transation;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryHolder> {

    private LayoutInflater mInflater;

    private List<Transation> transations;


    public HistoryAdapter(Context mContext, List<Transation> transations) {
        mInflater = LayoutInflater.from(mContext);
        this.transations = transations;
    }

    @Override
    public HistoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryHolder(R.layout.item_history, mInflater, parent);
    }

    @Override
    public void onBindViewHolder(HistoryHolder holder, int position) {
        Transation transation = transations.get(position);
        holder.render(transation);

    }

    @Override
    public int getItemCount() {
        return transations.size();
    }

    public void setTransations(List<Transation> transations) {
        this.transations = transations;
        notifyDataSetChanged();
    }
}
