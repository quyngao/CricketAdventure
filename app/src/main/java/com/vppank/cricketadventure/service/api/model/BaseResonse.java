package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by QUYLE on 3/31/18.
 */

public class BaseResonse implements Serializable {
    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
