package com.fuck.viewtest.serv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class ServAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start_serv;
    private Button btn_bind_serv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serv);
        initView();
        initUI();
    }


    private void initView() {
        btn_start_serv = findViewById(R.id.btn_start_serv);
        btn_bind_serv = findViewById(R.id.btn_bind_serv);
    }


    private void initUI() {
        btn_start_serv.setOnClickListener(this);
        btn_bind_serv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start_serv: {
                Intent intent = new Intent(this, MyService.class);
                startService(intent);
                break;
            }
            case R.id.btn_bind_serv: {
                break;
            }
        }
    }
}
