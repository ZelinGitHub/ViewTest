package com.fuck.viewtest.menu.net.okhttp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpRequestGet {

    public void requestGet() {
        //创建客户端
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();

        //创建请求
        Request request = new Request.Builder()
                //设置请求地址
                .url("https://www.baidu.com")
                //构造请求
                .build();

        //准备发送请求
        Call call = okHttpClient.newCall(request);

        //发送同步请求
        try {
            Response response = call.execute();
        } catch (IOException pE) {
            pE.printStackTrace();
        }

        //发送异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }
}
