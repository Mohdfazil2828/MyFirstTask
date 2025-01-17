package com.myfirsttask.UserApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://www.backfour.in/user/";
    private static RetrofitClient retrofitClient;

    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance() {
    if (retrofitClient == null){
        retrofitClient = new RetrofitClient();
    }
    return retrofitClient;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
