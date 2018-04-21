package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by QUYLE on 3/31/18.
 */

public class User implements Serializable {
    @SerializedName("_id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("birthday")
    private String birthday;

    @SerializedName("email")
    private String email;

    @SerializedName("avatar")
    private String avatar;

    @SerializedName("balance")
    private int balance;

    @SerializedName("totalWeed")
    private int totalWeed;


    @SerializedName("totalTravel")
    private int totalTravel;

    @SerializedName("hasInternetBanking")
    private boolean hasInternetBanking;

    @SerializedName("hasCreditCard")
    private boolean hasCreditCard;

    public String getAvatar() {
        return avatar;
    }
    @SerializedName("atHome")
    private boolean atHome = true;

    @SerializedName("items")
    private ArrayList<Integer> items = new ArrayList<>();

    @SerializedName("balo")
    private ArrayList<Integer> itemsInBalo = new ArrayList<>();

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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public boolean isHasInternetBanking() {
        return hasInternetBanking;
    }

    public void setHasInternetBanking(boolean hasInternetBanking) {
        this.hasInternetBanking = hasInternetBanking;
    }

    public int getTotalWeed() {
        return totalWeed;
    }

    public int getTotalTravel() {
        return totalTravel;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isHasCreditCard() {
        return hasCreditCard;
    }

    public void setHasCreditCard(boolean hasCreditCard) {
        this.hasCreditCard = hasCreditCard;
    }

    public ArrayList<Integer> getItems() {
        return items;
    }

    public void setItems(ArrayList<Integer> items) {
        this.items = items;
    }

    public ArrayList<Integer> getItemsInBalo() {
        return itemsInBalo;
    }

    public void setItemsInBalo(ArrayList<Integer> itemsInBalo) {
        this.itemsInBalo = itemsInBalo;
    }

    public boolean isAtHome() {
        return atHome;
    }

    public void setAtHome(boolean atHome) {
        this.atHome = atHome;
    }
}
