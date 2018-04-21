package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Notification implements Serializable{
    @SerializedName("type")
    private String type;

    @SerializedName("body")
    private String body;

    @SerializedName("createdAtString")
    private String createdAtString;

    public String getType() {
        return type;
    }

    public String getBody() {
        return body;
    }

    public String getCreatedAtString() {
        return createdAtString;
    }
}
