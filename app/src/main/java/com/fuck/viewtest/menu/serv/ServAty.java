package com.fuck.viewtest.menu.serv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.serv.client.MyClientAty;
import com.fuck.viewtest.menu.serv.client.Client1Aty;
import com.fuck.viewtest.menu.serv.client.Client2Aty;

public class ServAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_my_client;
    private Button btn_client1;
    private Button btn_client2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serv);
        initView();
        initUI();
    }


    private void initView() {
        btn_my_client = findViewById(R.id.btn_my_client);
        btn_client1 = findViewById(R.id.btn_client1);
        btn_client2 = findViewById(R.id.btn_client2);
    }


    private void initUI() {
        btn_my_client.setOnClickListener(this);
        btn_client1.setOnClickListener(this);
        btn_client2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_my_client: {
                Intent intent = new Intent(this, MyClientAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_client1: {
                Intent intent = new Intent(this, Client1Aty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_client2: {
                Intent intent = new Intent(this, Client2Aty.class);
                startActivity(intent);
                break;
            }

        }
    }


}
