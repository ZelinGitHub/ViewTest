package com.fuck.viewtest.menu.serv.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.serv.server.MyIntentService;
import com.fuck.viewtest.menu.serv.server.MyService;

import java.util.Date;

public class MyClientAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start_serv;
    private Button btn_stop_serv;

    private Button btn_start_intent_serv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_my);
        initView();
        initUI();
    }


    private void initView() {
        btn_start_serv = findViewById(R.id.btn_start_serv);
        btn_stop_serv = findViewById(R.id.btn_stop_serv);
        btn_start_intent_serv = findViewById(R.id.btn_start_intent_serv);


    }


    private void initUI() {
        btn_start_serv.setOnClickListener(this);
        btn_stop_serv.setOnClickListener(this);
        btn_start_intent_serv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_serv: {
                startServ(this);
                break;
            }
            case R.id.btn_stop_serv: {
                stopServ(this);
                break;
            }
            case R.id.btn_start_intent_serv: {
                startIntentServ(this);
                break;
            }

        }
    }

    private void startServ(Context pContext) {
        System.out.println("MyClientAty 启动Service");
        Intent intent = new Intent(pContext, MyService.class);
        intent.putExtra("data", new Date().toString());
        startService(intent);
    }


    private void stopServ(Context pContext) {
        System.out.println("MyClientAty 停止Service");
        Intent intent = new Intent(pContext, MyService.class);
        stopService(intent);
    }


    private void startIntentServ(Context pContext) {
        System.out.println("MyClientAty 启动IntentService");

        Intent intent = new Intent(pContext, MyIntentService.class);
        intent.putExtra("data", new Date().toString());
        startService(intent);
    }

}
