package com.fuck.viewtest.menu.net.okhttp.cookie;

import okhttp3.CookieJar;
import okhttp3.OkHttpClient;

public class OkHttpCookieTest {
    public void fuckCookie() {
        CookieJar cookieJar = new MyCookieJar();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cookieJar(cookieJar)
                .build();

    }
}
