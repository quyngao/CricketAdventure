package com.vppank.cricketadventure.service.api;

import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by QUYLE on 3/4/18.
 */

public class ApiClient {
    public static final String BASE_URL = "http://144.202.4.51:3000";
    private static Retrofit retrofit = null;
    private static RestInterface mRestIntances;


    public static Retrofit getClient() {
        if (retrofit == null) {
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .readTimeout(20, TimeUnit.SECONDS)
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();

                            Response response = chain.proceed(request);

                            int tryCount = 0;
                            while (!response.isSuccessful() && tryCount < 3) {
                                Log.d("intercept", "Request is not successful - " + tryCount);
                                tryCount++;
                                response = chain.proceed(request);
                            }
                            return response;
                        }
                    })
                    .build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }


    public static RestInterface getRestInstance() {
        if (mRestIntances == null) {
            mRestIntances = ApiClient.getClient().create(RestInterface.class);
        }
        return mRestIntances;
    }



}
