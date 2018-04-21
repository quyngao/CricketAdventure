package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by QUYLE on 3/31/18.
 */

public class UserResponse extends BaseResonse {

    @SerializedName("data")
    private User user;

    public User getUser() {
        return user;
    }



}
