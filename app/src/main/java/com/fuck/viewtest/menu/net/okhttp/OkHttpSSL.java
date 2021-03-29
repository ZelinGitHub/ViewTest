package com.fuck.viewtest.menu.net.okhttp;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;

public class OkHttpSSL {
    public void fuck() {
        try {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            SecureRandom secureRandom = new SecureRandom();
//            sslContext.init(null, trustManagers, secureRandom);

            SocketFactory socketFactory = sslContext.getSocketFactory();

        } catch (NoSuchAlgorithmException pE) {
            pE.printStackTrace();
        }
    }
}
