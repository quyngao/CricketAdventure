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

    @SerializedName("phone")
    private String phone;

    @SerializedName("imei")
    private String imei;

    @SerializedName("date")
    private String date;

    @SerializedName("createdAt")
    private String createdAt;

    private Date expiredTime;


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getImei() {
        return imei;
    }

    public String getDate() {
        return date;
    }

    public String getCreatedAt() {
        return createdAt;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getExpiredTime() {
        return expiredTime;
    }
}
