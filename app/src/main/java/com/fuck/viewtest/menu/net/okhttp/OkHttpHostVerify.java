package com.fuck.viewtest.menu.net.okhttp;

import javax.net.ssl.HostnameVerifier;

import okhttp3.OkHttpClient;

public class OkHttpHostVerify {
    public void fuckHostVerify() {
        HostnameVerifier hostnameVerifier=new MyHostnameVerifier();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .hostnameVerifier(hostnameVerifier)
                .build();

    }
}
