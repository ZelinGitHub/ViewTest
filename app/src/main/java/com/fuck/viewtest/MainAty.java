package com.fuck.viewtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.anim.AnimAty;
import com.fuck.viewtest.broadcast.BroadcastAty;
import com.fuck.viewtest.cusview.CusvAty;
import com.fuck.viewtest.img.ImgAty;
import com.fuck.viewtest.rv.RvAty;
import com.fuck.viewtest.serv.client.ServAty;
import com.fuck.viewtest.socket.client.SocketAty;
import com.fuck.viewtest.vp.VpAty;
import com.fuck.viewtest.win.WinAty;

//ABC
public class MainAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_vp;
    private Button btn_anim;
    private Button btn_win;
    private Button btn_serv;
    private Button btn_broadcast;
    private Button btn_socket;
    private Button btn_cusv;
    private Button btn_img;
    private Button btn_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initUI();
    }


    private void initView() {
        btn_vp = findViewById(R.id.btn_vp);
        btn_anim = findViewById(R.id.btn_anim);
        btn_win = findViewById(R.id.btn_win);
        btn_serv = findViewById(R.id.btn_serv);
        btn_broadcast = findViewById(R.id.btn_broadcast);
        btn_socket = findViewById(R.id.btn_socket);
        btn_cusv = findViewById(R.id.btn_cusv);
        btn_img = findViewById(R.id.btn_img);
        btn_rv = findViewById(R.id.btn_rv);
    }


    private void initUI() {
        btn_vp.setOnClickListener(this);
        btn_anim.setOnClickListener(this);
        btn_win.setOnClickListener(this);
        btn_serv.setOnClickListener(this);
        btn_broadcast.setOnClickListener(this);
        btn_socket.setOnClickListener(this);
        btn_cusv.setOnClickListener(this);
        btn_img.setOnClickListener(this);
        btn_rv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_vp: {
                Intent intent = new Intent(this, VpAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_anim: {
                Intent intent = new Intent(this, AnimAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_win: {
                Intent intent = new Intent(this, WinAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_serv: {
                Intent intent = new Intent(this, ServAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_broadcast: {
                Intent intent = new Intent(this, BroadcastAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_socket: {
                Intent intent = new Intent(this, SocketAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_cusv: {
                Intent intent = new Intent(this, CusvAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_img: {
                Intent intent = new Intent(this, ImgAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_rv: {
                Intent intent = new Intent(this, RvAty.class);
                startActivity(intent);
                break;
            }
        }
    }
}
