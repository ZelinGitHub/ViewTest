package com.fuck.viewtest.menu.aidl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class AIDLAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_book_client;
    private Button btn_pool_client;
    private Button btn_messenger_client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_book_client = findViewById(R.id.btn_book_client);
        btn_pool_client = findViewById(R.id.btn_pool_client);
        btn_messenger_client = findViewById(R.id.btn_messenger_client);
    }

    private void initUI() {
        btn_book_client.setOnClickListener(this);
        btn_pool_client.setOnClickListener(this);
        btn_messenger_client.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_book_client: {
                Intent intent = new Intent(this, BookClientAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_pool_client: {
                Intent intent = new Intent(this, PoolClientAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_messenger_client: {
                Intent intent = new Intent(this, MessengerClientAty.class);
                startActivity(intent);
                break;
            }

        }
    }

}