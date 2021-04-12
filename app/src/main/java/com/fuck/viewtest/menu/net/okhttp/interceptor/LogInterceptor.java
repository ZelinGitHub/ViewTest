package com.fuck.viewtest.menu.net.okhttp.interceptor;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;

public class LogInterceptor implements Interceptor {

    private final Charset UTF8 = StandardCharsets.UTF_8;

    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

        RequestBody requestBody = request.body();
        if (requestBody != null) {
            logRequestBody(requestBody);
        }
        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        if (responseBody != null) {
            logResponseBody(response, responseBody);
        }
        Log.i("网络请求拦截日志：", "请求和响应结束");
        return response;
    }


    private void logRequestBody(RequestBody requestBody) throws IOException {
        //把请求正文写到buffer
        okio.Buffer buffer = new okio.Buffer();
        requestBody.writeTo(buffer);
        //得到的媒体类型
        MediaType mediaType = requestBody.contentType();
        //如果请求体的媒体类型是
        if (mediaType != null && mediaType.toString().startsWith("application/json")) {
            //设置正文类型的编码
            Charset charset = mediaType.charset(UTF8);
            //用指定编码取出请求正文
            if (charset != null) {
                String string = buffer.readString(charset);
                //并打印请求正文
                Log.i("网络请求拦截日志：", "request " + string);
            }
        } else {
            //请求体媒体类型不是为空，或者不是json
            Log.i("网络请求拦截日志：", "request " + "Multiple different charsets");
        }
    }

    private void logResponseBody(Response response, ResponseBody responseBody) throws IOException {
        //保存所有响应正文
        BufferedSource source = responseBody.source();
        source.request(java.lang.Long.MAX_VALUE); // Buffer the entire body.
        okio.Buffer buffer = source.buffer();
        //响应体媒体类型
        MediaType mediaType = responseBody.contentType();
        //如果响应体媒体类型是
        if (mediaType != null && mediaType.toString().startsWith("text/html")) {
            //设置正文类型的编码
            Charset charset = mediaType.charset(UTF8);
            //假如响应体不为空
            if (responseBody.contentLength() != 0L) {
                if (charset != null) {
                    //用指定编码打印响应正文
                    String string = buffer.clone().readString(charset);
                    Log.i("网络请求拦截日志：", "response " + response + " " + string);
                }
            } else {
                Log.i("网络请求拦截日志：", "response " + response);
            }
        } else {
            Log.i("网络请求拦截日志：", "response " + response + " Multiple different charsets");
        }
    }


}
