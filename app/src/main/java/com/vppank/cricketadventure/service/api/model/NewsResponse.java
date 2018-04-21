package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsResponse extends BaseResonse {
    @SerializedName("news")
    List<New> news;

    public List<New> getNews() {
        return news;
    }
}
