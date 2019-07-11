package com.myfirsttask.UserApi;

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


}
