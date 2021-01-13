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

public class Client2Aty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_bind_serv;
    private Button btn_unbind_serv;
    private Button btn_client1;

    private ServiceConnection mConnection = new Connection2();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client2);
        initView();
        initUI();
    }


    private void initView() {
        btn_bind_serv = findViewById(R.id.btn_bind_serv);
        btn_unbind_serv = findViewById(R.id.btn_unbind_serv);
        btn_client1 = findViewById(R.id.btn_client1);
    }


    private void initUI() {
        btn_bind_serv.setOnClickListener(this);
        btn_unbind_serv.setOnClickListener(this);
        btn_client1.setOnClickListener(this);
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
            case R.id.btn_client1: {
                Intent intent = new Intent(this, Client1Aty.class);
                startActivity(intent);
                break;
            }

        }
    }


    private void bindServ(Context pContext) {
        System.out.println("Client2Aty 绑定Service");
        Intent intent = new Intent(pContext, MyService.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


    private void unbindServ() {
        System.out.println("Client2Aty 解绑Service");
        unbindService(mConnection);
    }

}
