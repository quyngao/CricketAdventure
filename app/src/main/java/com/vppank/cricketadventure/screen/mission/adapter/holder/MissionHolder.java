package com.vppank.cricketadventure.screen.mission.adapter.holder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.mission.adapter.listenner.OnMissionItemClickListenner;
import com.vppank.cricketadventure.service.api.model.New;
import com.vppank.cricketadventure.service.api.model.Transation;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MissionHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.container)
    protected View container;

    @BindView(R.id.content)
    protected ImageView content;

    @BindView(R.id.title)
    protected TextView title;


    New aNew;
    OnMissionItemClickListenner missionItemClickListenner;

    public MissionHolder(View itemView) {
        super(itemView);
    }

    public MissionHolder(@LayoutRes int layoutRes, LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(layoutRes, parent, false));
        ButterKnife.bind(this, itemView);
    }

    public void render(New anew) {
        this.aNew = anew;
        title.setText(anew.getTitle());
        Picasso.get().load(anew.getImages().get(0)).into(content);

        container.setBackgroundResource(!aNew.isRead() ? R.color.background_has_service : R.color.background_hasnt_service);


        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aNew != null && missionItemClickListenner != null) {

                    missionItemClickListenner.onMissioItemClicked(aNew);
                }
            }
        });
    }

    public void setMissionItemClickListenner(OnMissionItemClickListenner missionItemClickListenner) {
        this.missionItemClickListenner = missionItemClickListenner;
    }
}
