package com.fuck.viewtest.menu.net.okhttp.hostname;

import javax.net.ssl.HostnameVerifier;

import okhttp3.OkHttpClient;

public class OkHttpHostVerifyTest {
    public void fuckHostVerify() {
        HostnameVerifier hostnameVerifier=new TrustAllHostnameVerifier();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .hostnameVerifier(hostnameVerifier)
                .build();

    }
}
