package com.fuck.viewtest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class BroadcastAty extends AppCompatActivity implements View.OnClickListener {

    public static final String BROADCAST_ACTION = "BROADCAST_ACTION";
    public static final String BROADCAST_PERMISSION = "BROADCAST_PERMISSION";
    private BroadcastReceiver mBroadcastReceiver = new MyBroadcastReceiver();
    private BroadcastReceiver mBroadcastReceiver2 = new MyBroadcastReceiver2();
    private BroadcastReceiver mBroadcastReceiver3 = new MyBroadcastReceiver3();

    private Button btn_send_broadcast;
    private Button btn_send_order_broadcast;

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
    }

    private void initUI() {
        btn_send_broadcast.setOnClickListener(this);
        btn_send_order_broadcast.setOnClickListener(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerBroadcast();
        registerBroadcast2();
        registerBroadcast3();
    }

    private void registerBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(3);
        intentFilter.addAction(BROADCAST_ACTION);
        registerReceiver(mBroadcastReceiver, intentFilter);
    }

    private void registerBroadcast2() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(20);
        intentFilter.addAction(BROADCAST_ACTION);
        registerReceiver(mBroadcastReceiver2, intentFilter);
    }

    private void registerBroadcast3() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.setPriority(100);
        intentFilter.addAction(BROADCAST_ACTION);
        registerReceiver(mBroadcastReceiver3, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mBroadcastReceiver);
        unregisterReceiver(mBroadcastReceiver2);
        unregisterReceiver(mBroadcastReceiver3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send_broadcast: {
                Intent intent = new Intent();
                intent.setAction(BROADCAST_ACTION);
                intent.putExtra("data","我是无序广播");
                sendBroadcast(intent);
                break;
            }
            case R.id.btn_send_order_broadcast: {
                Intent intent = new Intent();
                intent.setAction(BROADCAST_ACTION);
                intent.putExtra("data","我是有序广播");
                sendOrderedBroadcast(intent,null);
                break;
            }
        }
    }
}
