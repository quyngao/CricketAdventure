package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FriendsResponse extends BaseResonse{
    @SerializedName("friends")
    List<Friend> friends;

    public List<Friend> getFriends() {
        return friends;
    }
}
