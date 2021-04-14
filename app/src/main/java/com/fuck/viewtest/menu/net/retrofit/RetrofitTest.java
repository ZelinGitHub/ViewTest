package com.fuck.viewtest.menu.net.retrofit;

import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitTest {

    public static final String BASE_URL = "https:\\www.";


    public RequestAPI getAPIS(String pUrl) {
        return new Retrofit.Builder()
                .baseUrl(pUrl)
                //设置自定义的OkHttp客户端
                .client(
                        getOkHttpClient()
                )
                .build().create(RequestAPI.class);
    }

    public RequestAPI getAPIS2(String pUrl) {
        //创建GsonConverterFactory实例
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(new GsonBuilder().create());
        return new Retrofit.Builder()
                .baseUrl(pUrl)
                //设置自定义的OkHttp客户端
                .client(
                        getOkHttpClient()
                )
                //可选的，设置数据转换器
                //设置GsonConverterFactory
                .addConverterFactory(gsonConverterFactory)
                .build().create(RequestAPI.class);
    }

    public RequestAPI getAPIS3(String pUrl) {
        NoBodyConverterFactory noBodyConverterFactory = new NoBodyConverterFactory();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(new GsonBuilder().create());
        return new Retrofit.Builder()
                .baseUrl(pUrl)
                //设置自定义的OkHttp客户端
                .client(
                        getOkHttpClient()
                )
                //可选的，设置数据转换器
                //设置NoBodyConverterFactory
                //NoBodyConverter一定要在GsonConverter之前设置
                .addConverterFactory(noBodyConverterFactory)
                //设置GsonConverterFactory
                .addConverterFactory(gsonConverterFactory)
                .build().create(RequestAPI.class);
    }

    public RequestAPI getAPIS4(String pUrl) {
        NoBodyConverterFactory noBodyConverterFactory = new NoBodyConverterFactory();
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(new GsonBuilder().create());
        //创建RxJavaCallAdapterFactory
        RxJavaCallAdapterFactory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
        return new Retrofit.Builder()
                .baseUrl(pUrl)
                //设置自定义的OkHttp客户端
                .client(
                        getOkHttpClient()
                )
                //可选的，设置数据解析器
                .addConverterFactory(noBodyConverterFactory)
                .addConverterFactory(gsonConverterFactory)
                //可选的，设置调用适配器
                .addCallAdapterFactory(rxJavaCallAdapterFactory)
                .build().create(RequestAPI.class);
    }


    //创建OkHttpClient
    private OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }

    private void getData1() {
        try {
            Response<ResponseBody> response = getAPIS(BASE_URL)
                    .getData(0, "Tom")
                    .execute();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    private void getData2() {
        getAPIS(BASE_URL)
                .getData(0, "Tom")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }

    private void die1() {
        try {
            Response<ResponseBody> response = getAPIS(BASE_URL)
                    .die(0, "Tom", "Male")
                    .execute();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    private void die2() {
        getAPIS(BASE_URL)
                .die(0, "Tom", "Male")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });
    }

    private void fuck() {
        //创建字符串请求体
        //MediaType是text/plain;charset=UTF-8
        RequestBody strBody =
                RequestBody.create(
                        MediaType.parse("text/plain;charset=UTF-8")
                        , "linda"
                );

        File file = new File("/abc.txt");
        //创建文件请求体
        //MediaType是multipart/form-data
        RequestBody fileBody = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        //创建MultipartBody.Part
        MultipartBody.Part fileBodyPart = MultipartBody.Part.createFormData("image_stream", file.getName(), fileBody);
        try {
            getAPIS(BASE_URL)
                    .fuck(strBody, fileBodyPart)
                    .execute();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    private void fuckAll() {
        //创建字符串请求体
        //MediaType是text/plain;charset=UTF-8
        RequestBody strBody =
                RequestBody.create(
                        MediaType.parse("text/plain;charset=UTF-8")
                        , "linda"
                );

        File file1 = new File("/a.txt");
        File file2 = new File("/b.txt");
        File file3 = new File("/c.txt");
        //创建文件请求体
        //MediaType是multipart/form-data
        RequestBody fileBody1 = RequestBody.create(MediaType.parse("multipart/form-data"), file1);
        RequestBody fileBody2 = RequestBody.create(MediaType.parse("multipart/form-data"), file2);
        RequestBody fileBody3 = RequestBody.create(MediaType.parse("multipart/form-data"), file3);

        //创建MultipartBody.Part
        MultipartBody.Part fileBodyPart1 = MultipartBody.Part.createFormData("image_stream", file1.getName(), fileBody1);
        MultipartBody.Part fileBodyPart2 = MultipartBody.Part.createFormData("image_stream", file2.getName(), fileBody2);
        MultipartBody.Part fileBodyPart3 = MultipartBody.Part.createFormData("image_stream", file3.getName(), fileBody3);

        MultipartBody.Part[] fileBodyParts={fileBodyPart1,fileBodyPart2,fileBodyPart3};
        try {
            getAPIS(BASE_URL)
                    .fuckAll(strBody, fileBodyParts)
                    .execute();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }
}
