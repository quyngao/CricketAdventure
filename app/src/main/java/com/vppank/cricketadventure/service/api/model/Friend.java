package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Friend implements Serializable {
    @SerializedName("_id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("hasInternetBanking")
    private String hasInternetBanking;

    @SerializedName("hasCreditCard")
    private String hasCreditCard;

    @SerializedName("totalWeed")
    private int totalWeed;

    @SerializedName("totalTravel")
    private int totalTravel;

    public void setId(String id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHasInternetBanking(String hasInternetBanking) {
        this.hasInternetBanking = hasInternetBanking;
    }

    public void setHasCreditCard(String hasCreditCard) {
        this.hasCreditCard = hasCreditCard;
    }

    public void setTotalWeed(int totalWeed) {
        this.totalWeed = totalWeed;
    }

    public void setTotalTravel(int totalTravel) {
        this.totalTravel = totalTravel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHasInternetBanking() {
        return hasInternetBanking;
    }

    public String getHasCreditCard() {
        return hasCreditCard;
    }

    public int getTotalWeed() {
        return totalWeed;
    }

    public int getTotalTravel() {
        return totalTravel;
    }
}
