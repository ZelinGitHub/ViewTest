package com.fuck.viewtest.menu.net.okhttp.interceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request_1 = chain.request();
        String method = request_1.method();
        switch (method) {
            case "GET": {
                Request request_2 = addGetToken(request_1);
                return chain.proceed(request_2);
            }
            case "POST": {
                Request request_2 = addPostToken(request_1);
                return chain.proceed(request_2);
            }
            default: {
                return chain.proceed(request_1);
            }
        }

    }

    private Request addGetToken(Request pRequest) {
        Request.Builder requestBuilder = pRequest.newBuilder();
        //得到HttpUrl
        HttpUrl httpUrl_1 = pRequest.url();
        //构造新的HttpUrl的Builder
        HttpUrl.Builder httpUrlBuilder = httpUrl_1.newBuilder();
        //为HttpUrl增加参数
        httpUrlBuilder.addQueryParameter("token", "ABC");
        //构造新的HttpUrl
        HttpUrl httpUrl_2 = httpUrlBuilder.build();
        //设置HttpUrl
        requestBuilder.url(httpUrl_2);
        //构造请求体
        return requestBuilder.build();
    }

    private Request addPostToken(Request pRequest) {
        //原来的请求体
        RequestBody requestBody = pRequest.body();
        if (requestBody instanceof FormBody) {
            //重新构造请求体的Builder
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            //添加原来请求体的所有参数
            FormBody requestBody__ = (FormBody) requestBody;
            for (int i = 0; i < requestBody__.size(); i++) {
                String name = requestBody__.name(i);
                String value = requestBody__.value(i);
                formBodyBuilder.add(name, value);
            }
            return addPostToken(pRequest, formBodyBuilder);
        } else if (requestBody instanceof MultipartBody) {
            return addGetToken(pRequest);
        } else {
            FormBody.Builder formBodyBuilder = new FormBody.Builder();
            return addPostToken(pRequest, formBodyBuilder);
        }
    }

    @NotNull
    private Request addPostToken(
            Request pRequest
            , FormBody.Builder pFormBodyBuilder) {
        Request.Builder requestBuilder = pRequest.newBuilder();
        String method = pRequest.method();
        //添加token参数
        pFormBodyBuilder.add("token", "ABC");
        //重新构造请求体
        FormBody formBody = pFormBodyBuilder.build();
        //设置新的请求体
        requestBuilder.method(method, formBody);
        //构造请求体
        return requestBuilder.build();
    }
}
