package com.fuck.viewtest.menu.net.okhttp;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;

//实现cookie的自定义管理
//保存cookie到内存
public class MyCookieJar implements CookieJar {
    private final HashMap<String, List<Cookie>> mStringListHashMap
            = new HashMap<>();

    @Override
    public void saveFromResponse(HttpUrl url, @NotNull List<Cookie> cookies) {
        String host = url.host();
        mStringListHashMap.put(host, cookies);
    }

    @NotNull
    @Override
    public List<Cookie> loadForRequest(HttpUrl url) {
        String host = url.host();
        List<Cookie> cookies = mStringListHashMap.get(host);
        if (cookies != null) {
            return cookies;
        } else {
            return new ArrayList<>();
        }
    }
}
