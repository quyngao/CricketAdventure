package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by QUYLE on 3/31/18.
 */

public class UserResponse extends BaseResonse {

    @SerializedName("user")
    private User user;

    @SerializedName("tranQuantity")
    private TranQuantity tranQuantity;

    @SerializedName("accessToken")
    private String token;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public TranQuantity getTranQuantity() {
        return tranQuantity;
    }

}
