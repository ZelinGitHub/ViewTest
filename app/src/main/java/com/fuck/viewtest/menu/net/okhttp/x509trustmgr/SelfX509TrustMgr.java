package com.fuck.viewtest.menu.net.okhttp.x509trustmgr;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.Arrays;
import java.util.Collection;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class SelfX509TrustMgr {

    //获取信任自签名证书的X509TrustManager
    private X509TrustManager trustManagerForCertificates(InputStream in)
            throws GeneralSecurityException {
        //得到证书工厂
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        //使用证书工厂，得到自签名证书集合
        Collection<? extends Certificate> certificates=certificateFactory.generateCertificates(in);

        if (certificates.isEmpty()) {
            throw new IllegalArgumentException("expected non-empty set of trusted certificates");
        }

        //密钥库的密码
        char[] password = "password".toCharArray();
        //得到密钥库
        KeyStore keyStore = getEmptyKeyStore(password);
        int index = 0;
        //遍历证书数组
        for (Certificate certificate : certificates) {
            //使用索引值作为证书的别名
            String certificateAlias = Integer.toString(index++);
            //把证书导入密钥库中
            keyStore.setCertificateEntry(certificateAlias, certificate);
        }

        //得到密钥管理器工厂
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(
                KeyManagerFactory.getDefaultAlgorithm());
        //初始化密钥管理器工厂
        //参数1传入密钥库
        //参数2传入密钥库的密码
        keyManagerFactory.init(keyStore, password);


        //得到TrustManagerFactory实例
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm());
        //初始化TrustManagerFactory，参数传入密钥库
        trustManagerFactory.init(keyStore);
        //得到TrustManager数组
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

        if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
            throw new IllegalStateException("Unexpected default trust managers:"
                    + Arrays.toString(trustManagers));
        }
        return (X509TrustManager) trustManagers[0];
    }


    private KeyStore getEmptyKeyStore(char[] password) throws GeneralSecurityException {
        try {
            //得到KeyStore实例
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            InputStream in = null;
            //参数1传入空的输入流，使用空的输入流，创建空的密钥库
            //参数2传入密钥库的密码
            keyStore.load(null, password);
            return keyStore;
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
