package com.fuck.viewtest.serv.client;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.serv.server.MyIntentService;
import com.fuck.viewtest.serv.server.MyService;

import java.util.Date;

public class ServAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start_serv;
    private Button btn_stop_serv;
    private Button btn_bind_serv;
    private Button btn_unbind_serv;
    private Button btn_start_intent_serv;
    private ServiceConnection mConnection = new MyConnection();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serv);
        initView();
        initUI();
    }


    private void initView() {
        btn_start_serv = findViewById(R.id.btn_start_serv);
        btn_stop_serv = findViewById(R.id.btn_stop_serv);
        btn_bind_serv = findViewById(R.id.btn_bind_serv);
        btn_unbind_serv = findViewById(R.id.btn_unbind_serv);
        btn_start_intent_serv = findViewById(R.id.btn_start_intent_serv);
    }


    private void initUI() {
        btn_start_serv.setOnClickListener(this);
        btn_stop_serv.setOnClickListener(this);
        btn_bind_serv.setOnClickListener(this);
        btn_unbind_serv.setOnClickListener(this);
        btn_start_intent_serv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_serv: {
                Intent intent = new Intent(this, MyService.class);
                intent.putExtra("data",new Date().toString());
                startService(intent);
                break;
            }
            case R.id.btn_stop_serv: {
                Intent intent = new Intent(this, MyService.class);
                stopService(intent);
                break;
            }
            case R.id.btn_bind_serv: {
                Intent intent = new Intent(this, MyService.class);
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
                break;
            }
            case R.id.btn_unbind_serv: {
                unbindService(mConnection);
                break;
            }
            case R.id.btn_start_intent_serv: {
                Intent intent = new Intent(this, MyIntentService.class);
                intent.putExtra("data",new Date().toString());
                startService(intent);
                break;
            }
        }
    }
}
