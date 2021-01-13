package com.fuck.viewtest.menu.leak;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

//ABC
public class HandlerCtxAty extends AppCompatActivity implements View.OnClickListener {

    private MyHandler mMyHandler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_ctx);
        initView();
        initUI();
    }


    @Override
    public void onClick(View v) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void initView() {

    }


    private void initUI() {
        Message message = mMyHandler.obtainMessage();
        message.what = 1;
        mMyHandler.sendMessageDelayed(message, 20000);
    }

    static class MyHandler extends Handler {
        private Context mContext;

        public MyHandler(Context pContext) {
            mContext = pContext;
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1: {
                    Toast.makeText(mContext, "收到消息", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
