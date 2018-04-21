package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;


/**
 * Created by QUYLE on 3/31/18.
 */

public class User implements Serializable {
    @SerializedName("_id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("balance")
    private String balance;

    @SerializedName("hasInternetBanking")
    private boolean hasInternetBanking;

    @SerializedName("hasCreditCard")
    private boolean hasCreditCard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public boolean isHasInternetBanking() {
        return hasInternetBanking;
    }

    public void setHasInternetBanking(boolean hasInternetBanking) {
        this.hasInternetBanking = hasInternetBanking;
    }

    public boolean isHasCreditCard() {
        return hasCreditCard;
    }

    public void setHasCreditCard(boolean hasCreditCard) {
        this.hasCreditCard = hasCreditCard;
    }
}
