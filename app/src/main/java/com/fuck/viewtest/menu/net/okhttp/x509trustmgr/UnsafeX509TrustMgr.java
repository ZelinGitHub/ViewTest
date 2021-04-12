package com.fuck.viewtest.menu.net.okhttp.x509trustmgr;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 证书信任管理器
 */
public class UnsafeX509TrustMgr implements X509TrustManager {

    //检查客户端的证书
    //客户端一般不需要证书，什么都不做
    @Override
    public void checkClientTrusted(X509Certificate[] pX509Certificates, String pS) throws CertificateException {
        System.out.println("检查客户端的证书");
    }

    //检查服务端的证书
    //通过自己实现该方法，使之信任我们指定的证书
    //什么都不做，信任服务端的任何证书
    @Override
    public void checkServerTrusted(X509Certificate[] pX509Certificates, String pS) throws CertificateException {
        System.out.println("检查服务端的证书");
    }

    //返回受信任的X509证书数组
    //返回空的，表示没有证书
    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
