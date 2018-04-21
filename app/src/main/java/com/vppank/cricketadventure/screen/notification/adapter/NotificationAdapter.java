package com.vppank.cricketadventure.screen.notification.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.history.adapter.holder.HistoryHolder;
import com.vppank.cricketadventure.screen.notification.adapter.holder.NotificationHolder;
import com.vppank.cricketadventure.screen.notification.adapter.listenner.OnNotificationItemClickListener;
import com.vppank.cricketadventure.service.api.model.Notification;
import com.vppank.cricketadventure.service.api.model.Transation;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationHolder>{
    private LayoutInflater mInflater;

    private List<Notification> notifications;

    OnNotificationItemClickListener itemClickListener;


    public NotificationAdapter(Context mContext, List<Notification> notifications) {
        mInflater = LayoutInflater.from(mContext);
        this.notifications = notifications;
    }

    @Override
    public NotificationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new NotificationHolder(R.layout.item_notification, mInflater, parent);

    }

    @Override
    public void onBindViewHolder(NotificationHolder holder, int position) {
        Notification notification = notifications.get(position);
        holder.render(notification);

    }

    @Override
    public int getItemCount() {
        return notifications.size();
    }

    public void setItemClickListener(OnNotificationItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
        notifyDataSetChanged();
    }
}
