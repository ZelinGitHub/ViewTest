package com.fuck.viewtest.okhttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;

class OkHttpTest {
    public static void test(){
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();


        Request request=new Request.Builder()
                .url("https://www.baidu.com")
                .build();
    }
}
