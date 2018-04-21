package com.vppank.cricketadventure.service.api;


import com.vppank.cricketadventure.service.api.model.TransationResponse;
import com.vppank.cricketadventure.service.api.model.TransationsResonse;
import com.vppank.cricketadventure.service.api.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by QUYLE on 3/4/18.
 */

public interface RestInterface {

    @GET(UrlConstants.CHECK_IMEI_DEVICE)
    Call<UserResponse> checkImei(@Query("imei") String iMei);

    @POST(UrlConstants.LOGIN_FB)
    @FormUrlEncoded
    Call<UserResponse> loginFacebook(@Field("facebookToken") String token);

    @GET(UrlConstants.PROFILE_USER)
    Call<UserResponse> getProfile();

    @GET(UrlConstants.ALL_TRANSATION)
    Call<TransationsResonse> getAllTransation();

    @POST(UrlConstants.CREATE_TRANSATION)
    @FormUrlEncoded
    Call<TransationResponse> creatTransation(@Field("type") int type);

    @POST(UrlConstants.REGISTER_SERVICE)
    @FormUrlEncoded
    Call<UserResponse> registerService(@Field("hasInternetBanking") boolean hasInternetBanking, @Field("hasCreditCard") boolean hasCreditCard);

}
