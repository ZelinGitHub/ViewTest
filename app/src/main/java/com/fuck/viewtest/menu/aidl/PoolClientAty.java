package com.fuck.viewtest.menu.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aidlserver.IComputeMgr;
import com.example.aidlserver.IPoolMgr;
import com.example.aidlserver.ISecurityMgr;
import com.fuck.viewtest.R;
import com.fuck.viewtest.cons.Const;

import static com.fuck.viewtest.cons.Const.BINDER_CODE_COMPUTE;
import static com.fuck.viewtest.cons.Const.BINDER_CODE_SECURITY;

public class PoolClientAty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_bind_pool_server;
    private Button btn_encrypt_on_server;
    private Button btn_decipher_on_server;
    private Button btn_plus_on_server;
    private Button btn_unbind_pool_server;


    private IPoolMgr mProxy;
    private PoolServiceConnection mPoolServiceConnection = new PoolServiceConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_client);
        initViews();
        initUI();
    }

    private void initViews() {

        btn_bind_pool_server = findViewById(R.id.btn_bind_pool_server);
        btn_encrypt_on_server = findViewById(R.id.btn_encrypt_on_server);
        btn_decipher_on_server = findViewById(R.id.btn_decipher_on_server);
        btn_plus_on_server = findViewById(R.id.btn_plus_on_server);
        btn_unbind_pool_server = findViewById(R.id.btn_unbind_pool_server);
    }

    private void initUI() {

        btn_bind_pool_server.setOnClickListener(this);
        btn_encrypt_on_server.setOnClickListener(this);
        btn_decipher_on_server.setOnClickListener(this);
        btn_plus_on_server.setOnClickListener(this);
        btn_unbind_pool_server.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bind_pool_server: {
                bindPoolServer(this);
                break;
            }
            case R.id.btn_encrypt_on_server: {
                encryptOnServer();
                break;
            }
            case R.id.btn_decipher_on_server: {
                decipherOnServer();
                break;
            }
            case R.id.btn_plus_on_server: {
                plusOnServer();
                break;
            }
            case R.id.btn_unbind_pool_server: {
                unbindPoolServer(this);
                break;
            }
        }
    }

    private void bindPoolServer(Context pContext) {
        if (mProxy == null) {
            System.out.println("客户端 连接服务端");
            Intent intent = new Intent();
            intent.setAction(Const.POOL_SERVER_INTENT_ACTION);
            intent.setPackage(Const.SERVER_PACKAGE);
            pContext.bindService(intent, mPoolServiceConnection, Context.BIND_AUTO_CREATE);
        } else {
            System.out.println("客户端 和服务端的连接已存在");
        }
    }

    private void encryptOnServer() {
        if (mProxy != null) {
            //IPC方法可能会阻塞，需要在子线程调用
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("客户端 远程得到服务端Binder");
                        IBinder serverBinder = mProxy.getBinder(BINDER_CODE_SECURITY);
                        ISecurityMgr serverBinderProxy = ISecurityMgr.Stub.asInterface(serverBinder);
                        String name = "ABC";
                        System.out.println("客户端 远程加密 " + name);
                        String result = serverBinderProxy.encrypt(name);
                        System.out.println("客户端 加密结果 " + result);
                    } catch (RemoteException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        } else {
            System.out.println("客户端 没有连接到服务端");
        }

    }

    private void decipherOnServer() {
        if (mProxy != null) {
            //IPC方法可能会阻塞，需要在子线程调用
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("客户端 远程得到服务端Binder");
                        IBinder serverBinder = mProxy.getBinder(BINDER_CODE_SECURITY);
                        ISecurityMgr serverBinderProxy = ISecurityMgr.Stub.asInterface(serverBinder);
                        String password = "123";
                        System.out.println("客户端 远程解密 " + password);
                        String result = serverBinderProxy.decipher(password);
                        System.out.println("客户端 解密结果 " + result);
                    } catch (RemoteException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        } else {
            System.out.println("客户端 没有连接到服务端");
        }
    }

    private void plusOnServer() {
        if (mProxy != null) {
            //IPC方法可能会阻塞，需要在子线程调用
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("客户端 远程得到服务端Binder");
                        IBinder serverBinder = mProxy.getBinder(BINDER_CODE_COMPUTE);
                        IComputeMgr serverBinderProxy = IComputeMgr.Stub.asInterface(serverBinder);
                        System.out.println("客户端 远程计算 1+2=?");
                        int result = serverBinderProxy.plus(1, 2);
                        System.out.println("客户端 计算结果 " + result);
                    } catch (RemoteException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        } else {
            System.out.println("客户端 没有连接到服务端");
        }
    }

    private void unbindPoolServer(Context pContext) {
        if (mProxy != null) {
            System.out.println("客户端 断开和服务端的连接");
            pContext.unbindService(mPoolServiceConnection);
            mProxy = null;
        } else {
            System.out.println("客户端 没有连接到服务端");
        }
    }

    class PoolServiceConnection implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mProxy = IPoolMgr.Stub.asInterface(service);
            System.out.println("客户端 连接到服务端成功");

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("客户端 和服务端断开连接");
            mProxy = null;
        }
    }
}