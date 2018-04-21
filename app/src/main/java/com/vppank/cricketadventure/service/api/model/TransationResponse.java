package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

public class TransationResponse extends BaseResonse {
    @SerializedName("transaction")
    private Transation transation;

    public Transation getTransation() {
        return transation;
    }
}
