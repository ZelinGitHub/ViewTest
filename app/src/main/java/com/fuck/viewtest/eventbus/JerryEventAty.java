package com.fuck.viewtest.eventbus;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

import org.greenrobot.eventbus.EventBus;

//ABC
public class JerryEventAty extends AppCompatActivity implements View.OnClickListener {

    public Button btn_send_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_jerry);
        initView();
        initUI();
    }


    @Override
    public void onClick(View v) {
        EventBus.getDefault().post(new MyEvent("我是Jerry"));
    }


    private void initView() {
        btn_send_event=findViewById(R.id.btn_send_event);
    }


    private void initUI() {
        btn_send_event.setOnClickListener(this);
    }


}
