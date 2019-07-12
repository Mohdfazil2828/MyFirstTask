package com.myfirsttask.UserApi;

import com.myfirsttask.Model.GroundResponse;
import com.myfirsttask.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("api/user/login")
    Call<LoginResponse> login(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("api/ground/groundList")
    Call<GroundResponse> ground(
            @Field("api_code") String api_code
    );

}
