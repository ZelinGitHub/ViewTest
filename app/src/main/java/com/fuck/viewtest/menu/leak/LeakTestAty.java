package com.fuck.viewtest.menu.leak;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

//ABC
public class LeakTestAty extends AppCompatActivity implements View.OnClickListener {


    private Button btn_static_ctx;
    private Button btn_static_view;
    private Button btn_handler;
    private Button btn_thread;
    private Button btn_collection_not_empty;
    private Button btn_static_bmp;
    private Button btn_bmp_map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_test);
        initView();
        initUI();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_static_ctx: {
                Intent intent = new Intent(this, StaticCtxAty.class);
                startActivity(intent);
            }
            case R.id.btn_static_view: {

            }
            case R.id.btn_handler_ctx: {
                Intent intent = new Intent(this, HandlerCtxAty.class);
                startActivity(intent);
            }
            case R.id.btn_thread_ctx: {

            }
            case R.id.btn_collection_not_empty: {

            }
            case R.id.btn_static_bmp: {

            }
            case R.id.btn_bmp_map: {

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void initView() {
        btn_static_ctx = findViewById(R.id.btn_static_ctx);
        btn_static_view = findViewById(R.id.btn_static_view);
        btn_handler = findViewById(R.id.btn_handler_ctx);
        btn_thread = findViewById(R.id.btn_thread_ctx);
        btn_collection_not_empty = findViewById(R.id.btn_collection_not_empty);
        btn_static_bmp = findViewById(R.id.btn_static_bmp);
        btn_bmp_map = findViewById(R.id.btn_bmp_map);
    }


    private void initUI() {
        btn_static_ctx.setOnClickListener(this);
        btn_static_view.setOnClickListener(this);
        btn_handler.setOnClickListener(this);
        btn_thread.setOnClickListener(this);
        btn_collection_not_empty.setOnClickListener(this);
        btn_static_bmp.setOnClickListener(this);
        btn_bmp_map.setOnClickListener(this);
    }


}
