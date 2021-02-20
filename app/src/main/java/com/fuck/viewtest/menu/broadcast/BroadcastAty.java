package com.fuck.viewtest.menu.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.fuck.viewtest.R;

public class BroadcastAty extends AppCompatActivity implements View.OnClickListener {

    public static final String BROADCAST_ACTION = "BROADCAST_ACTION";
    public static final String BROADCAST_PERMISSION = "BROADCAST_PERMISSION";
    private BroadcastReceiver mBroadcastReceiver = new MyBroadcastReceiver();
    private BroadcastReceiver mBroadcastReceiver2 = new MyBroadcastReceiver2();
    private BroadcastReceiver mBroadcastReceiver3 = new MyBroadcastReceiver3();

    private Button btn_send_broadcast;
    private Button btn_send_order_broadcast;
    private Button btn_send_local_broadcast;
    private Button btn_send_local_sync_broadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_send_broadcast = findViewById(R.id.btn_send_broadcast);
        btn_send_order_broadcast = findViewById(R.id.btn_send_order_broadcast);
        btn_send_local_broadcast = findViewById(R.id.btn_send_local_broadcast);
        btn_send_local_sync_broadcast = findViewById(R.id.btn_send_local_sync_broadcast);
    }

    private void initUI() {
        btn_send_broadcast.setOnClickListener(this);
        btn_send_order_broadcast.setOnClickListener(this);
        btn_send_local_broadcast.setOnClickListener(this);
        btn_send_local_sync_broadcast.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcastReceiver(this);
        registerBroadcastReceiver2(this);
        registerBroadcastReceiver3(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unRegisterBroadcastReceiver(this);
        unRegisterBroadcastReceiver2(this);
        unRegisterBroadcastReceiver3(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_broadcast: {
                sendBroadcast(this);
                break;
            }
            case R.id.btn_send_order_broadcast: {
                sendOrderedBroadcast(this);
                break;
            }
            case R.id.btn_send_local_broadcast: {
                sendLocalBroadcast(this);
                break;
            }
            case R.id.btn_send_local_sync_broadcast: {
                sendLocalSyncOrderedBroadcast(this);
                break;
            }
        }
    }


    private void registerBroadcastReceiver(Context pContext) {
        //IntentFilter用来过滤Intent
        IntentFilter intentFilter = new IntentFilter();
        //优先级是一个整数，值越大优先级越高，取值范围为-1000到1000
        intentFilter.setPriority(3);
        //为IntentFilter添加Action，BroadcastReceiver只能接收到指定Action的广播（Intent）
        intentFilter.addAction(BROADCAST_ACTION);
        pContext.registerReceiver(mBroadcastReceiver, intentFilter);
    }

    private void registerBroadcastReceiver2(Context pContext) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(20);
        intentFilter.addAction(BROADCAST_ACTION);
        pContext.registerReceiver(mBroadcastReceiver2, intentFilter);
    }

    private void registerBroadcastReceiver3(Context pContext) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(100);
        intentFilter.addAction(BROADCAST_ACTION);
        pContext.registerReceiver(mBroadcastReceiver3, intentFilter);
    }

    private void unRegisterBroadcastReceiver(Context pContext) {
        pContext.unregisterReceiver(mBroadcastReceiver);
    }

    private void unRegisterBroadcastReceiver2(Context pContext) {
        pContext.unregisterReceiver(mBroadcastReceiver2);
    }

    private void unRegisterBroadcastReceiver3(Context pContext) {
        pContext.unregisterReceiver(mBroadcastReceiver3);
    }

    private void sendBroadcast(Context pContext) {
        Intent intent = new Intent();
        //只有BroadcastReceiver的IntentFilter的Action，和Intent的Action相同时
        //这个BroadcastReceiver才可以收到广播
        intent.setAction(BROADCAST_ACTION);
        intent.putExtra("data", "我是无序广播");
        pContext.sendBroadcast(intent);
    }

    private void sendOrderedBroadcast(Context pContext) {
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION);
        intent.putExtra("data", "我是有序广播");
        pContext.sendOrderedBroadcast(intent, null);
    }

    private void sendLocalBroadcast(Context pContext) {
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION);
        intent.putExtra("data", "我是本地异步广播");
        LocalBroadcastManager.getInstance(pContext).sendBroadcast(intent);
    }

    private void sendLocalSyncOrderedBroadcast(Context pContext) {
        Intent intent = new Intent();
        intent.setAction(BROADCAST_ACTION);
        intent.putExtra("data", "我是本地同步广播");
        LocalBroadcastManager.getInstance(pContext).sendBroadcastSync(intent);
    }
}
