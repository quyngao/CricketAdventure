package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TranQuantity implements Serializable {
    @SerializedName("type0")
    private int type0;

    @SerializedName("type1")
    private int type1;

    @SerializedName("type2")
    private int type2;

    @SerializedName("type3")
    private int type3;

    @SerializedName("type4")
    private int type4;

    @SerializedName("type5")
    private int type5;

    public void setType0(int type0) {
        this.type0 = type0;
    }

    public void setType1(int type1) {
        this.type1 = type1;
    }

    public void setType2(int type2) {
        this.type2 = type2;
    }

    public void setType3(int type3) {
        this.type3 = type3;
    }

    public void setType4(int type4) {
        this.type4 = type4;
    }

    public void setType5(int type5) {
        this.type5 = type5;
    }

    public int getType0() {
        return type0;
    }

    public int getType1() {
        return type1;
    }

    public int getType2() {
        return type2;
    }

    public int getType3() {
        return type3;
    }

    public int getType4() {
        return type4;
    }

    public int getType5() {
        return type5;
    }
}
