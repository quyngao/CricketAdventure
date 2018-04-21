package com.vppank.cricketadventure.screen.notification.adapter.holder;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.notification.adapter.listenner.OnNotificationItemClickListener;
import com.vppank.cricketadventure.service.api.model.Notification;
import com.vppank.cricketadventure.service.api.model.Transation;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.card_view)
    protected View container;



    @BindView(R.id.content)
    protected ImageView imageType;

    @BindView(R.id.title)
    protected TextView title;

    @BindView(R.id.time)
    protected TextView time;

    Notification notification;
    OnNotificationItemClickListener itemClickListener;

    public NotificationHolder(View itemView) {
        super(itemView);
    }

    public NotificationHolder(@LayoutRes int layoutRes, LayoutInflater inflater, ViewGroup parent) {
        this(inflater.inflate(layoutRes, parent, false));
        ButterKnife.bind(this, itemView);
    }

    public void render(Notification transation) {
        this.notification = transation;
        title.setText(transation.getBody());
        time.setText(transation.getCreatedAtString());


        container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notification!=null && itemClickListener !=null){
                    itemClickListener.onNotificationItemClicked(notification);
                }
            }
        });

        if(notification.getType().equalsIgnoreCase("transaction")){
            imageType.setImageResource(R.drawable.ic_noti_transation);
        }
        else if(notification.getType().equalsIgnoreCase("service")){
            imageType.setImageResource(R.drawable.ic_noti_service);
        }
        else if(notification.getType().equalsIgnoreCase("postcard")){
            imageType.setImageResource(R.drawable.ic_noti_postcard);
        }


    }

    public void setItemClickListener(OnNotificationItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
