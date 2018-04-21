package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransationsResonse  extends BaseResonse{


    @SerializedName("transactions")
    List<Transation> transations;

    public List<Transation> getTransations() {
        return transations;
    }
}
