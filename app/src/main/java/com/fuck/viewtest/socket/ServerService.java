package com.fuck.viewtest.socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerService extends Service {

    private boolean mIsServiceDestroyed = false;

    private String[] mDefinedMessages = new String[]{
            "How are you"
            , "What's your name?"
            , "Fuck you"
            , "Fuck me"
            , "You will Die"
    };

    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(new Runnable() {
            @Override
            public void run() {
                monitor();
            }
        }).start();
    }

    private void monitor() {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8688);
        } catch (IOException pE) {
            pE.printStackTrace();
        }

        while (!mIsServiceDestroyed && serverSocket != null) {
            try {
                final Socket socket = serverSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        process(socket);
                    }
                }).start();
            } catch (IOException pE) {
                pE.printStackTrace();
            }
        }
    }

    private void process(Socket pSocket) {
        try {





            OutputStream outputStream = pSocket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println("welcome");

            InputStream inputStream = pSocket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            while(!mIsServiceDestroyed){
                String str=bufferedReader.readLine();
                System.out.println("Message from client:"+str);
                if(str==null){
                    break;
                }
            }
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
