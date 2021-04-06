package com.fuck.viewtest.menu.net.okhttp;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

public class InterceptorTest {

    public void fuckInterceptor(Interceptor interceptor) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

    }
}
