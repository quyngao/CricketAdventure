package com.vppank.cricketadventure.service.api;


import com.vppank.cricketadventure.service.api.model.FriendsResponse;
import com.vppank.cricketadventure.service.api.model.NotificationsResponse;
import com.vppank.cricketadventure.service.api.model.BaseResonse;
import com.vppank.cricketadventure.service.api.model.GetMailResponse;
import com.vppank.cricketadventure.service.api.model.GetUserResponse;
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

    @GET(UrlConstants.NOTIFICATIONS)
    Call<NotificationsResponse> getNotifications();

    @GET(UrlConstants.FRIEND_LIST)
    Call<FriendsResponse> getFriends();

    @POST(UrlConstants.CREATE_TRANSATION)
    @FormUrlEncoded
    Call<TransationResponse> creatTransation(@Field("type") int type);

    @POST(UrlConstants.REGISTER_SERVICE)
    @FormUrlEncoded
    Call<UserResponse> registerService(@Field("hasInternetBanking") boolean hasInternetBanking, @Field("hasCreditCard") boolean hasCreditCard);

    @POST(UrlConstants.START_TRIP)
    @FormUrlEncoded
    Call<BaseResonse> startTrip(@Query("token") String token, @Field("item1") int item1, @Field("item2") int item2, @Field("item3") int item3);

    @GET(UrlConstants.GET_MAIL)
    Call<GetMailResponse> getMails(@Query("token") String token);

    @GET(UrlConstants.GET_PROFILE)
    Call<GetUserResponse> getUser(@Query("token") String token);

    @POST(UrlConstants.BUY_ITEM)
    @FormUrlEncoded
    Call<BaseResonse> buyItem(@Query("token") String token, @Field("code") int code);
}
