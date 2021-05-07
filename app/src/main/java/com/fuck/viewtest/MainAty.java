package com.fuck.viewtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.menu.aidl.AIDLAty;
import com.fuck.viewtest.menu.anno.AnnoAty;
import com.fuck.viewtest.menu.codeframe.CodeFrameAty;
import com.fuck.viewtest.menu.concurent.coroutine.CoroutineAty;
import com.fuck.viewtest.menu.concurent.coroutine.CoroutineTestKt;
import com.fuck.viewtest.menu.concurent.rxjava2.dispose.DisposeTestAty;
import com.fuck.viewtest.menu.datafile.res.ResAty;
import com.fuck.viewtest.menu.datafile.seria.SerialAty;
import com.fuck.viewtest.menu.display.aty.AtyAty;
import com.fuck.viewtest.menu.display.dialog.DialogAty;
import com.fuck.viewtest.menu.display.taskt.FirstAty;
import com.fuck.viewtest.menu.eventline.broadcast.BroadcastAty;
import com.fuck.viewtest.menu.eventline.eventbus.TomEventAty;
import com.fuck.viewtest.menu.img.ImgAty;
import com.fuck.viewtest.menu.leak.LeakTestAty;
import com.fuck.viewtest.menu.net.socket.client.SocketAty;
import com.fuck.viewtest.menu.service.ServAty;
import com.fuck.viewtest.menu.view_.ViewAty;
import com.fuck.viewtest.menu.view_.anim.AnimAty;
import com.fuck.viewtest.menu.window.WinAty;

//ABC
public class MainAty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_anim;
    private Button btn_win;
    private Button btn_serv;
    private Button btn_broadcast;
    private Button btn_socket;
    private Button btn_img;
    private Button btn_v;
    private Button btn_task;
    private Button btn_event_bus;
    private Button btn_dialog;
    private Button btn_anno;
    private Button btn_code_frame;
    private Button btn_rxjava2;
    private Button btn_leak;
    private Button btn_coroutine;

    private Button btn_serial;
    private Button btn_aty;
    private Button btn_aidl;
    private Button btn_res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initUI();
    }


    private void initViews() {
        btn_anim = findViewById(R.id.btn_anim);
        btn_win = findViewById(R.id.btn_win);
        btn_serv = findViewById(R.id.btn_serv);
        btn_broadcast = findViewById(R.id.btn_broadcast);
        btn_socket = findViewById(R.id.btn_socket);
        btn_img = findViewById(R.id.btn_img);
        btn_v = findViewById(R.id.btn_v);
        btn_task = findViewById(R.id.btn_task);
        btn_event_bus = findViewById(R.id.btn_event_bus);
        btn_dialog = findViewById(R.id.btn_dialog);
        btn_anno = findViewById(R.id.btn_anno);
        btn_code_frame = findViewById(R.id.btn_code_frame);
        btn_rxjava2 = findViewById(R.id.btn_rxjava2);
        btn_leak = findViewById(R.id.btn_leak);
        btn_coroutine = findViewById(R.id.btn_coroutine);

        btn_serial = findViewById(R.id.btn_serial);
        btn_aty = findViewById(R.id.btn_aty);
        btn_aidl = findViewById(R.id.btn_aidl);
        btn_res = findViewById(R.id.btn_res);
    }


    private void initUI() {
        btn_anim.setOnClickListener(this);
        btn_win.setOnClickListener(this);
        btn_serv.setOnClickListener(this);
        btn_broadcast.setOnClickListener(this);
        btn_socket.setOnClickListener(this);
        btn_img.setOnClickListener(this);
        btn_v.setOnClickListener(this);
        btn_task.setOnClickListener(this);
        btn_event_bus.setOnClickListener(this);
        btn_dialog.setOnClickListener(this);
        btn_anno.setOnClickListener(this);
        btn_code_frame.setOnClickListener(this);
        btn_rxjava2.setOnClickListener(this);
        btn_leak.setOnClickListener(this);
        btn_coroutine.setOnClickListener(this);

        btn_serial.setOnClickListener(this);
        btn_aty.setOnClickListener(this);
        btn_aidl.setOnClickListener(this);
        btn_res.setOnClickListener(this);
        CoroutineTestKt.testCoroutine();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

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

            case R.id.btn_img: {
                Intent intent = new Intent(this, ImgAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_v: {
                Intent intent = new Intent(this, ViewAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_task: {
                Intent intent = new Intent(this, FirstAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_event_bus: {
                Intent intent = new Intent(this, TomEventAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_dialog: {
                Intent intent = new Intent(this, DialogAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_anno: {
                Intent intent = new Intent(this, AnnoAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_code_frame: {
                Intent intent = new Intent(this, CodeFrameAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_rxjava2: {
                Intent intent = new Intent(this, DisposeTestAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_leak: {
                Intent intent = new Intent(this, LeakTestAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_coroutine: {
                Intent intent = new Intent(this, CoroutineAty.class);
                startActivity(intent);
                break;
            }

            case R.id.btn_serial: {
                Intent intent = new Intent(this, SerialAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_aty: {
                Intent intent = new Intent(this, AtyAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_aidl: {
                Intent intent = new Intent(this, AIDLAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_res: {
                Intent intent = new Intent(this, ResAty.class);
                startActivity(intent);
                break;
            }
        }
    }
}
