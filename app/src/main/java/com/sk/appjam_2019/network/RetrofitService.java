package com.sk.appjam_2019.network;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.json.JSONObject;

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

    @FormUrlEncoded
    @POST("/auth/signin")
    Call<JsonObject> login(@Field("id")String id,
                           @Field("password")String pw);

    @FormUrlEncoded
    @POST("/notice/addNotice")
    Call<JsonObject> addNotice(@Field("title")String title,
                               @Field("content")String content);

    @FormUrlEncoded
    @POST("/notice/delNotice")
    Call<JSONObject> delNotice(@Field("token")String token);

    @FormUrlEncoded
    @POST("/notice/loadNoticeOne")
    Call<JsonObject> loadNoticeOne(@Field("token")String token);

    @FormUrlEncoded
    @POST("/notice/loadNoticeList")
    Call<JSONObject> loadNoticeList();

    @FormUrlEncoded
    @POST("/closet/addNewDress")
    Call<JsonObject> addNewDress(@Field("content")String content,
                                 @Field("token")String token,
                                 @Field("img")String img);

    @FormUrlEncoded
    @POST("/closet/loadCloset")
    Call<JsonObject> loadCloset(@Field("token")String token);

    @FormUrlEncoded
    @POST("/closet/removeCloset")
    Call<JSONObject> removeCloset(@Field("token")String token);

    @FormUrlEncoded
    @POST("/comment/addComment")
    Call<JSONObject> addComment(@Field("content")String content,
                                @Field("name")String name,
                                @Field("token")String token);
}
