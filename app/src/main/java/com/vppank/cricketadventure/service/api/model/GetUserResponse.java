package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

public class GetUserResponse extends BaseResonse {
    @SerializedName("user")
    private User user;

    @SerializedName("atHome")
    private boolean atHome;

    public GetUserResponse(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isAtHome() {
        return atHome;
    }

    public void setAtHome(boolean atHome) {
        this.atHome = atHome;
    }
}
