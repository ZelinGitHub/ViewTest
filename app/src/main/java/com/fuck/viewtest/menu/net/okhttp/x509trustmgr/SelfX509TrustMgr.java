package com.fuck.viewtest.menu.net.okhttp.x509trustmgr;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
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
        //从输入流得到证书
        Collection<? extends Certificate> certificates = getCertificates(in);
        if (!certificates.isEmpty()) {
            //密钥库的密码
            char[] password = "123456".toCharArray();
            //得到密钥库
            KeyStore keyStore = getEmptyKeyStore(password);
            //导入证书到密钥库
            importCertificatesToKeyStore(certificates, keyStore);
            //初始化KeyManagerFactory
            initKeyManagerFactory(password, keyStore);
            //初始化TrustManagerFactory
            TrustManagerFactory trustManagerFactory = initTrustManagerFactory(keyStore);
            //得到TrustManager数组
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if(trustManagers.length==1){
                //得到TrustManager
                TrustManager trustManager = trustManagers[0];
                if(trustManager instanceof X509TrustManager){
                    //得到TrustManager
                    return (X509TrustManager) trustManager;
                }else {
                    throw new IllegalStateException("Unexpected default trust managers:"
                            + Arrays.toString(trustManagers));
                }
            }else {
                throw new IllegalStateException("Unexpected default trust managers:"
                        + Arrays.toString(trustManagers));
            }
        } else {
            throw new IllegalArgumentException("expected non-empty set of trusted certificates");
        }
    }




    /*
    得到证书文件对应的Certificate实例集合
     */
    private Collection<? extends Certificate> getCertificates(InputStream in) throws CertificateException {
        //得到证书工厂
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        //使用证书工厂，得到证书集合
        return certificateFactory.generateCertificates(in);
    }


    /*
    得到空的密钥库
     */
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

    /*
    导入证书到密钥库
     */
    private void importCertificatesToKeyStore(Collection<? extends Certificate> pCertificates, KeyStore pKeyStore) throws KeyStoreException {
        int index = 0;
        //遍历证书数组
        for (Certificate certificate : pCertificates) {
            //使用索引值作为证书的别名
            String certificateAlias = Integer.toString(index++);
            //把证书导入密钥库中
            pKeyStore.setCertificateEntry(certificateAlias, certificate);
        }
    }

    /*
    初始化KeyManagerFactory
     */
    private void initKeyManagerFactory(char[] pPassword, KeyStore pKeyStore) throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        //得到密钥管理器工厂
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(
                KeyManagerFactory.getDefaultAlgorithm());
        //初始化密钥管理器工厂
        //参数1传入密钥库
        //参数2传入密钥库的密码
        keyManagerFactory.init(pKeyStore, pPassword);
    }

    /*
    初始化TrustManagerFactory
     */
    private TrustManagerFactory initTrustManagerFactory(KeyStore pKeyStore) throws NoSuchAlgorithmException, KeyStoreException {
        //得到TrustManagerFactory实例
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                TrustManagerFactory.getDefaultAlgorithm());
        //初始化TrustManagerFactory，参数传入密钥库
        trustManagerFactory.init(pKeyStore);
        return trustManagerFactory;
    }

}
