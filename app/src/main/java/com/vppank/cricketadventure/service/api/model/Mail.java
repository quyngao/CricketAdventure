package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

public class Mail {
    @SerializedName("image")
    private String image;

    @SerializedName("createdAtString")
    private String createdAtString;

    @SerializedName("content")
    private String content;

    public Mail(String image, String createdAtString, String content) {
        this.image = image;
        this.createdAtString = createdAtString;
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreatedAtString() {
        return createdAtString;
    }

    public void setCreatedAtString(String createdAtString) {
        this.createdAtString = createdAtString;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
