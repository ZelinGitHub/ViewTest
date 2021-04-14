package com.fuck.viewtest.menu.net.retrofit;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface RequestAPI {
    @GET("baidu.com")
    Call<ResponseBody> getData(@Query("id") long id, @Query("name") String name);


    @FormUrlEncoded
    @POST("qq.com")
    Call<ResponseBody> die(
            @Field("id") long id
            , @Field("name") String name
            , @Field("sex") String sex
    );


    @Multipart
    @POST("fuck.com")
    Call<ResponseBody> fuck(
            @Part("girl") RequestBody girl
            , @Part MultipartBody.Part part
    );


    @Multipart
    @POST("fuck.com")
    Call<ResponseBody> fuckAll(
            @Part("girl") RequestBody girl
            , @Part MultipartBody.Part[] parts
    );


}
