package com.fuck.viewtest.menu.net.retrofit;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class NoBodyConverterFactory extends Converter.Factory {
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(
            @NotNull Type type
            , @NotNull Annotation[] annotations
            , Retrofit retrofit
    ) {

        Converter<ResponseBody, Object> delegate = retrofit.nextResponseBodyConverter(
                this
                , type
                , annotations
        );
        //局部类，实现Converter
        class MyConverter implements Converter<ResponseBody, Object> {

            @Override
            public Object convert(ResponseBody value) throws IOException {
                //如果没有响应体
                if (value.contentLength() == 0) {
                    return null;
                } else {
                    return delegate.convert(value);
                }
            }
        }
        return new MyConverter();
    }
}
