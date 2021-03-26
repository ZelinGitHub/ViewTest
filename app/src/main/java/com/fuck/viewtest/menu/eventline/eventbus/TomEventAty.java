package com.fuck.viewtest.menu.eventline.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

//ABC
public class TomEventAty extends AppCompatActivity implements View.OnClickListener {
    public Button btn_open_jerry;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_event_tom);
        initView();
        initUI();
    }


    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, JerryEventAty.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(MyEvent pMyEvent) {
        System.out.println("Tom收到事件：" + pMyEvent.content);
    }

    private void initView() {
        btn_open_jerry = findViewById(R.id.btn_open_jerry);
    }


    private void initUI() {
        btn_open_jerry.setOnClickListener(this);
    }


}
