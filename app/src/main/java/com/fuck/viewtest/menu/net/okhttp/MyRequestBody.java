package com.fuck.viewtest.menu.net.okhttp;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

public class MyRequestBody extends RequestBody {

    @Override
    public MediaType contentType() {
        return MediaType.get("text/x-markdown; charset=utf-8");
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        byte[] bytes = "Fuck you!!".getBytes();
        sink.write(bytes);
    }
}
