package com.fuck.viewtest.menu.net.okhttp.interceptor;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Random;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {
    @NotNull
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Random random = new Random();
        int i = random.nextInt(89999) + 10000;
        //为所有请求统一添加header
        Request request = chain.request().newBuilder()
                //告诉服务器，客户端支持的数据类型
                .addHeader("accept", "*/*")
                //请求完之后是保持连接(close)还是关闭连接(Keep-Alive)
                .addHeader("connection", "Keep-Alive")
                .addHeader("CLIENT-ID", "1")
                .addHeader("Random", String.valueOf(i)).build();
        return chain.proceed(request);
    }

}
