package com.vppank.cricketadventure.screen.social.adapter.holder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.service.api.model.Friend;
import com.vppank.cricketadventure.service.api.model.Notification;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FriendHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.content)
    protected ImageView imageType;

    @BindView(R.id.title)
    protected TextView title;

    @BindView(R.id.travel)
    protected TextView travel;

    @BindView(R.id.weed)
    protected TextView weed;

    @BindView(R.id.txtRank)
    protected TextView rank;

    Friend friend;


    public FriendHolder(View itemView) {
        super(itemView);
    }

    public FriendHolder(@LayoutRes int layoutRes, LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(layoutRes, parent, false));
        ButterKnife.bind(this, itemView);
    }

    public void render(Friend friend, int position) {
        this.friend = friend;
        title.setText(friend.getName());
        weed.setText(String.format("Thu thập: %d \uD83C\uDF40", friend.getTotalWeed()));
        travel.setText(String.format("Khám phá: %d km", friend.getTotalTravel()));
        Picasso.get().load(friend.getAvatar()).into(imageType);
        if (position == 0) {
            rank.setVisibility(View.VISIBLE);
            rank.setText(itemView.getContext().getText(R.string.onest));
        }
        if (position == 1){
            rank.setVisibility(View.VISIBLE);
            rank.setText(itemView.getContext().getText(R.string.twost));
        }
        if (position == 2){
            rank.setVisibility(View.VISIBLE);
            rank.setText(itemView.getContext().getText(R.string.threest));
        }
        if (position > 2){
            rank.setVisibility(View.INVISIBLE);
        }
    }


}
