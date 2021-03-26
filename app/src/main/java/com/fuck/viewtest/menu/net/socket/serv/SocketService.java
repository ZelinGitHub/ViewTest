package com.fuck.viewtest.menu.net.socket.serv;

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

/**
 * 使用Socket实现IPC的Service
 */
public class SocketService extends Service {

    private volatile boolean mIsServiceDestroyed;
    private volatile ServerSocket mServerSocket;


    @Override
    public void onCreate() {
        super.onCreate();
        //在子线程开启对端口的监听
        new Thread(new Runnable() {
            @Override
            public void run() {
                monitor();
            }
        }).start();
    }

    private void monitor() {
        //ServerSocket用来监听端口
        try {
            mServerSocket = new ServerSocket(8688);
        } catch (IOException pE) {
            pE.printStackTrace();
        }

        while (!mIsServiceDestroyed && mServerSocket != null) {
            try {
                //监听端口，这个方法会阻塞，直到返回客户端和服务端的连接Socket
                //ServerSocket关闭时，阻塞中的accept方法将抛出异常，解除阻塞
                final Socket socket = mServerSocket.accept();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //处理客户端和服务端的连接Socket
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
            //输出流
            OutputStream outputStream = pSocket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter, true);
            printWriter.println("我是服务端");

            //输入流
            InputStream inputStream = pSocket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            //依次接收客户端的消息
            while (!mIsServiceDestroyed) {
                String str = bufferedReader.readLine();
                System.out.println("服务端 收到客户度消息：" + str);
                //客户端发送null，表示这个客户端离开
                if (str == null) {
                    break;
                }
                //接收客户端的消息后，向客户端返回消息
                printWriter.println("我是服务端的消息");
            }
            System.out.println("服务端 客户端离开");
            //关闭客户端连接服务端的Socket的输出流和输入流
            printWriter.close();
            bufferedReader.close();
            //关闭客户端连接服务端的Socket
            pSocket.close();
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mIsServiceDestroyed = true;
        if (mServerSocket != null) {
            try {
                mServerSocket.close();
            } catch (IOException pE) {
                pE.printStackTrace();
            }
        }
    }
}
