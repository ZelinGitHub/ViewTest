package com.fuck.viewtest.menu.serv.client;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.serv.server.MyService;

import java.util.Date;

public class Client1Aty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_bind_serv;
    private Button btn_unbind_serv;
    private Button btn_start_serv;
    private Button btn_stop_serv;


    private ServiceConnection mConnection = new Connection1();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client1);
        initView();
        initUI();
    }


    private void initView() {

        btn_bind_serv = findViewById(R.id.btn_bind_serv);
        btn_unbind_serv = findViewById(R.id.btn_unbind_serv);
        btn_start_serv = findViewById(R.id.btn_start_serv);
        btn_stop_serv = findViewById(R.id.btn_stop_serv);
    }


    private void initUI() {

        btn_bind_serv.setOnClickListener(this);
        btn_unbind_serv.setOnClickListener(this);
        btn_start_serv.setOnClickListener(this);
        btn_stop_serv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btn_bind_serv: {
                bindServ(this);
                break;
            }
            case R.id.btn_unbind_serv: {
                unbindServ();
                break;
            }
            case R.id.btn_start_serv: {
                startServ(this);
                break;
            }
            case R.id.btn_stop_serv: {
                stopServ(this);
                break;
            }
        }
    }


    private void bindServ(Context pContext) {
        System.out.println("Client1Aty 绑定Service");
        Intent intent = new Intent(pContext, MyService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


    private void unbindServ() {
        System.out.println("Client1Aty 解绑Service");
        unbindService(mConnection);
    }

    private void startServ(Context pContext) {
        System.out.println("Client1Aty 启动Service");
        Intent intent = new Intent(pContext, MyService.class);
        intent.putExtra("data", new Date().toString());
        startService(intent);
    }


    private void stopServ(Context pContext) {
        System.out.println("Client1Aty 停止Service");
        Intent intent = new Intent(pContext, MyService.class);
        stopService(intent);
    }

}
