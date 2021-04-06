package com.fuck.viewtest.menu.net.okhttp;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class OkHttpSSLSocketFactory {
    public void fuck() {
        try {
            //证书管理器
            X509TrustManager x509TrustManager = new MyX509TrustMgr();
            //证书管理器数组，只有一个元素
            X509TrustManager[] x509TrustManagers = new X509TrustManager[]{x509TrustManager};
            //得到SSLContext
            SSLContext sslContext = SSLContext.getInstance("SSL");
            //创建安全随机数
            SecureRandom secureRandom = new SecureRandom();
            //初始化SSLContext
            //参数1密钥工厂，客户端不需要证书，传null
            //参数2传入证书管理器
            //参数3传入安全随机数
            sslContext.init(null, x509TrustManagers, secureRandom);
            //得到SSLSocketFactory
            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            //为OkHttpClient设置socketFactory
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .sslSocketFactory(socketFactory, x509TrustManager)
                    .build();
        } catch (
                NoSuchAlgorithmException
                        | KeyManagementException
                        pNoSuchAlgorithmException
        ) {
            pNoSuchAlgorithmException.printStackTrace();
        }
    }

}
