package com.vppank.cricketadventure.service.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetMailResponse extends BaseResonse {
    @SerializedName("postcards")
    private ArrayList<Mail> mails = new ArrayList<>();

    public ArrayList<Mail> getMails() {
        return mails;
    }

    public void setMails(ArrayList<Mail> mails) {
        this.mails = mails;
    }
}
