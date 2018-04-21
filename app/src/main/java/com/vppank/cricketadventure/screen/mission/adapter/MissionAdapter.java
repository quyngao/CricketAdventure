package com.vppank.cricketadventure.screen.mission.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.history.adapter.holder.HistoryHolder;
import com.vppank.cricketadventure.screen.mission.adapter.holder.MissionHolder;
import com.vppank.cricketadventure.screen.mission.adapter.listenner.OnMissionItemClickListenner;
import com.vppank.cricketadventure.service.api.model.New;
import com.vppank.cricketadventure.service.api.model.Transation;

import java.util.List;

public class MissionAdapter extends RecyclerView.Adapter<MissionHolder> {
    private LayoutInflater mInflater;
    private List<New> news;
    private OnMissionItemClickListenner itemClickListenner;


    public MissionAdapter(Context mContext, List<New> news) {
        mInflater = LayoutInflater.from(mContext);
        this.news = news;
    }

    @Override
    public MissionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MissionHolder(R.layout.item_new, mInflater, parent);
    }

    @Override
    public void onBindViewHolder(MissionHolder holder, int position) {
        New aNew = news.get(position);
        holder.render(aNew);
        holder.setMissionItemClickListenner(itemClickListenner);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public void setNews(List<New> news) {
        this.news = news;
        notifyDataSetChanged();
    }

    public void setItemClickListenner(OnMissionItemClickListenner itemClickListenner) {
        this.itemClickListenner = itemClickListenner;
    }
}
