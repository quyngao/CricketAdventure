package com.vppank.cricketadventure.screen.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.vppank.cricketadventure.R;
import com.vppank.cricketadventure.screen.common.BaseActivity;
import com.vppank.cricketadventure.screen.main.MainActivity;
import com.vppank.cricketadventure.service.api.ApiClient;
import com.vppank.cricketadventure.service.api.model.UserResponse;
import com.vppank.cricketadventure.share.UserInfo;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {


    CallbackManager callbackManager = CallbackManager.Factory.create();


    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        boolean loggedIn = AccessToken.getCurrentAccessToken() == null;
//        if (loggedIn) {
//            handleLogin(AccessToken.getCurrentAccessToken().getToken().toString());
//        }
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email", "user_friends", "public_profile");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.e("Token", loginResult.getAccessToken().getToken().toString());
                handleLogin(loginResult.getAccessToken().getToken().toString());
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {

            }
        });
    }

    private void handleLogin(String facebookToken){
        showLoadingDialog();
        ApiClient.getRestInstance().loginFacebook(facebookToken)
                .enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        dissmissLoadingDialog();
                        if (response.body().isSuccess()){
                            UserInfo.getInstance().setAccessToken(response.body().getToken());
                            UserInfo.getInstance().setUser(response.body().getUser());
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            LoginActivity.this.finish();
                        } else {
                            showMessageError(response.body().getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        showMessageError("Đăng nhập thất bại");
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
