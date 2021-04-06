package com.fuck.viewtest.menu.net.okhttp;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class OkHttpSSL {
    public void fuck(TrustManager[] trustManagers, X509TrustManager x509TrustManager) {
        SSLContext sslContext = initSSLContext(trustManagers);

        //得到套接字工厂
        SSLSocketFactory socketFactory = sslContext.getSocketFactory();

        //为OkHttpClient设置socketFactory
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .sslSocketFactory(socketFactory, x509TrustManager)
                .build();
    }

    private SSLContext initSSLContext(TrustManager[] trustManagers) {

        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL");
            SecureRandom secureRandom = new SecureRandom();
            //初始化SSLContext
            sslContext.init(null, trustManagers, secureRandom);
        } catch (
                NoSuchAlgorithmException
                        | KeyManagementException
                        pNoSuchAlgorithmException
        ) {
            pNoSuchAlgorithmException.printStackTrace();
        }

        return sslContext;
    }
}
