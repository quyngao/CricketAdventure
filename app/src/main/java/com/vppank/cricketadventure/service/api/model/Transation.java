package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.NumberFormat;

public class Transation implements Serializable{
    @SerializedName("balance")
    private int balance;

    @SerializedName("addedGameBalance")
    private int addedGameBalance;

    @SerializedName("type")
    private int type;

    @SerializedName("createdAtString")
    private String createdAtString;

    public int getAddedGameBalance() {
        return addedGameBalance;
    }

    public int getType() {
        return type;
    }

    public String getCreatedAtString() {
        return createdAtString;
    }

    public String getBalance() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(balance);
    }
}
