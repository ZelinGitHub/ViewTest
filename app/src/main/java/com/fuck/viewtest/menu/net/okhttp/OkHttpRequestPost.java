package com.fuck.viewtest.menu.net.okhttp;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpRequestPost {

    public void requestPost() {
        //创建客户端
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();

        //创建请求体
        MediaType mediaType = MediaType.get("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(
                mediaType
                , "abc"
        );
        //创建请求
        Request request = new Request.Builder()
                //设置请求地址
                .url("https://www.baidu.com")
                //设置请求体
                .post(requestBody)
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

    public void createStringRequestBody() {
        MediaType mediaType = MediaType.get("application/json;charset=utf-8");
        RequestBody requestBody = RequestBody.create(
                mediaType
                , "abc"
        );
    }

    public void createFileRequestBody() {
        MediaType mediaType = MediaType.get("text/x-markdown; charset=utf-8");
        File file = new File("/abc.txt");
        RequestBody requestBody = RequestBody.create(mediaType, file);
    }

    public void createFormRequestBody() {
        RequestBody formBody = new FormBody.Builder()
                .add("id", "001")
                .add("userName", "Hitler")
                .add("site", "Germany")
                .build();

    }

    public void createMultipartRequestBody() {
        MediaType mediaType = MediaType.get("text/x-markdown; charset=utf-8");
        File file = new File("/abc.txt");
        RequestBody fileRequestBody = RequestBody.create(mediaType, file);

        RequestBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("userName", "Hitler")
                .addFormDataPart("file", "abc", fileRequestBody)
                .build();
    }
}
