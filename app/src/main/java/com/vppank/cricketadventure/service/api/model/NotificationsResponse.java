package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NotificationsResponse extends BaseResonse{
    @SerializedName("notifications")
    List<Notification> notifications;

    public List<Notification> getNotifications() {
        return notifications;
    }
}
