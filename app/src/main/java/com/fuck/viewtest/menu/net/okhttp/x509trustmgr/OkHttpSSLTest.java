package com.fuck.viewtest.menu.net.okhttp.x509trustmgr;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

public class OkHttpSSLTest {

    //证书管理器
    X509TrustManager mX509TrustMgr = new UnsafeX509TrustMgr();


    public SSLSocketFactory getSocketFactory() {
        try {
            //证书管理器数组，只有一个元素
            X509TrustManager[] x509TrustManagers = new X509TrustManager[]{mX509TrustMgr};
            //得到SSLContext
            SSLContext sslContext = SSLContext.getInstance("SSL");
            //创建安全随机数
            SecureRandom secureRandom = new SecureRandom();
            //初始化SSLContext
            //参数1密钥工厂，客户端不需要证书，传null
            //参数2传入证书管理器数组
            //参数3传入安全随机数
            sslContext.init(null, x509TrustManagers, secureRandom);
            //得到SSLSocketFactory
            return sslContext.getSocketFactory();
        } catch (
                NoSuchAlgorithmException
                        | KeyManagementException
                        pNoSuchAlgorithmException
        ) {
            pNoSuchAlgorithmException.printStackTrace();
        }
        return null;
    }


    public void fuckOkHttpSocketFactory() {
        SSLSocketFactory socketFactory = getSocketFactory();
        if (socketFactory != null) {
            //为OkHttpClient设置socketFactory
            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .sslSocketFactory(socketFactory, mX509TrustMgr)
                    .build();
        }
    }

}
