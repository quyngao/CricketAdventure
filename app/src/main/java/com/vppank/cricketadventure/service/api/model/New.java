package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class New implements Serializable {
    @SerializedName("_id")
    private String id;

    @SerializedName("title")
    private String title;

    @SerializedName("read")
    private boolean read;

    @SerializedName("images")
    private List<String> images;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isRead() {
        return read;
    }

    public List<String> getImages() {
        return images;
    }
}
