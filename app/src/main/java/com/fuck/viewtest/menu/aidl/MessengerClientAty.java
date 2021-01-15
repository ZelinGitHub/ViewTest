package com.fuck.viewtest.menu.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.cons.Const;

import static com.fuck.viewtest.cons.Const.KEY_CLIENT_MSG;
import static com.fuck.viewtest.cons.Const.KEY_SERVER_MSG;

public class MessengerClientAty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_bind_messenger_server;
    private Button btn_send_msg;
    private Button btn_unbind_messenger_server;


    private MessengerServiceConnection mMessengerServiceConnection = new MessengerServiceConnection();

    private Messenger mServerMessenger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger_client);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_bind_messenger_server = findViewById(R.id.btn_bind_messenger_server);
        btn_send_msg = findViewById(R.id.btn_send_msg_to_server);
        btn_unbind_messenger_server = findViewById(R.id.btn_unbind_messenger_server);
    }

    private void initUI() {
        btn_bind_messenger_server.setOnClickListener(this);
        btn_send_msg.setOnClickListener(this);
        btn_unbind_messenger_server.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bind_messenger_server: {
                bindMessengerServer(this);
                break;
            }
            case R.id.btn_send_msg_to_server: {
                sendMsgToServer();
                break;
            }
            case R.id.btn_unbind_messenger_server: {
                unbindMessengerServer(this);
                break;
            }
        }
    }

    private void bindMessengerServer(Context pContext) {
        if (mServerMessenger == null) {
            System.out.println("客户端 连接服务端");
            Intent intent = new Intent();
            intent.setAction(Const.MESSENGER_SERVER_INTENT_ACTION);
            intent.setPackage(Const.SERVER_PACKAGE);
            pContext.bindService(intent, mMessengerServiceConnection, Context.BIND_AUTO_CREATE);
        } else {
            System.out.println("客户端 和服务端的连接已存在");
        }
    }

    private void sendMsgToServer() {
        if (mServerMessenger != null) {
            //IPC方法可能会阻塞，需要在子线程调用
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Message message = Message.obtain();
                        //Messenger必须用Bundle传递常规类型数据
                        //否则会报错：
                        // java.lang.RuntimeException:
                        // Can't marshal non-Parcelable objects across processes
                        Bundle bundle = new Bundle();
                        bundle.putString(KEY_CLIENT_MSG, "How are u?");
                        message.setData(bundle);
                        MessengerHandler messengerHandler = new MessengerHandler(
                                Looper.getMainLooper()
                        );
                        message.replyTo = new Messenger(messengerHandler);
                        System.out.println("客户端 向服务端远程发送消息 "
                                + message.getData().getString(KEY_CLIENT_MSG));
                        mServerMessenger.send(message);
                    } catch (RemoteException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        } else {
            System.out.println("客户端 没有连接到服务端");
        }

    }


    private void unbindMessengerServer(Context pContext) {
        if (mServerMessenger != null) {
            System.out.println("客户端 断开和服务端的连接");
            pContext.unbindService(mMessengerServiceConnection);
            mServerMessenger = null;
        } else {
            System.out.println("客户端 没有连接到服务端");
        }
    }

    class MessengerServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            System.out.println("客户端 连接到服务端成功");
            mServerMessenger = new Messenger(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("客户端 和服务端断开连接");
            mServerMessenger = null;
        }
    }

    static class MessengerHandler extends Handler {
        public MessengerHandler(@NonNull Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            System.out.println("客户端 收到消息 "
                    + msg.getData().getString(KEY_SERVER_MSG));
        }
    }
}