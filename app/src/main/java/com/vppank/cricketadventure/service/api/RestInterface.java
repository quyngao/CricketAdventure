package com.vppank.cricketadventure.service.api;


import com.vppank.cricketadventure.service.api.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by QUYLE on 3/4/18.
 */

public interface RestInterface {

    @GET(UrlConstants.CHECK_IMEI_DEVICE)
    Call<UserResponse> checkImei(@Query("imei") String iMei);

}
