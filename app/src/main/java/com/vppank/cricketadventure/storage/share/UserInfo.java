package com.vppank.cricketadventure.storage.share;

import com.vppank.cricketadventure.service.api.model.User;

public class UserInfo {

    private User user;

    private String accessToken;

    private static final UserInfo ourInstance = new UserInfo();

    public static UserInfo getInstance() {
        return ourInstance;
    }

    private UserInfo() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
