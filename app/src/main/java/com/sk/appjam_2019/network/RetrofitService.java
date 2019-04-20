package com.sk.appjam_2019.network;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitService {
    public static final String BASE_URL = "http://15.164.103.82:3000";

    @FormUrlEncoded
    @POST("/auth/signup")
    Call<JsonObject> signUp(@Field("id")String id,
                            @Field("password")String pw,
                            @Field("name")String name,
                            @Field("address")String address,
                            @Field("birthday")String birthday);

    @POST("/auth/signin")
    Call<JsonObject> login(@Field("id")String id,
                            @Field("password")String pw);
}
