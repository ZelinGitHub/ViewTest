package com.fuck.viewtest.menu.socket.client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.socket.serv.SocketService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketAty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_con_serv;
    private Button btn_send_data;
    private Button btn_terminate_connect;
    private Intent mIntent;

    private volatile PrintWriter mPrintWriter;
    private volatile boolean mIsConnect;
    private volatile Socket mSocket;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_con_serv = findViewById(R.id.btn_con_serv);
        btn_send_data = findViewById(R.id.btn_send_data);
        btn_terminate_connect = findViewById(R.id.btn_terminate_connect);
    }

    private void initUI() {
        btn_con_serv.setOnClickListener(this);
        btn_send_data.setOnClickListener(this);
        btn_terminate_connect.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        beginService();
    }


    @Override
    protected void onPause() {
        super.onPause();
        terminateService();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_con_serv: {
                //连接服务应该放到子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        connectService();
                    }
                }).start();
                break;
            }
            case R.id.btn_send_data: {
                //发送数据应该放到子线程
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendData();
                    }
                }).start();
                break;
            }
            case R.id.btn_terminate_connect: {
                terminateConnect();
                break;
            }
        }
    }

    private void beginService() {
        //开启服务
        mIntent = new Intent(this, SocketService.class);
        startService(mIntent);
    }

    private void terminateService() {
        //断开和服务端的连接
        if (mIsConnect) {
            terminateConnect();
        }
        //结束服务
        stopService(mIntent);
    }

    private void connectService() {
        //防止重复连接
        if (mSocket == null) {
            try {
                System.out.println("客户端 准备连接服务器");
                //本地主机的主机名是localhost
                //连接服务器
                mSocket = new Socket("localhost", 8688);
                System.out.println("客户端 连接服务器成功");
                mIsConnect = true;
                //输出流
                //输出流不会阻塞
                OutputStream outputStream = mSocket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
                //参数2表示是否自动刷新
                mPrintWriter = new PrintWriter(bufferedWriter, true);
                //输入流
                //输入流可能会阻塞
                InputStream inputStream = mSocket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                //循环读取服务端返回的消息
                while (mIsConnect) {
                    String message = bufferedReader.readLine();
                    System.out.println("客户端 收到服务端消息：" + message);
                }
                mPrintWriter.close();
                bufferedReader.close();
            } catch (IOException pE) {
                pE.printStackTrace();
            }
        }
    }

    private void sendData() {
        if (mPrintWriter != null) {
            mPrintWriter.println("我是客户端的消息");
        }
    }

    /**
     * 断开连接
     */
    private void terminateConnect() {
        mIsConnect = false;
        if (mSocket != null) {
            try {
                mSocket.shutdownOutput();
                mSocket = null;
            } catch (IOException pE) {
                pE.printStackTrace();
            }
        }
    }
}
