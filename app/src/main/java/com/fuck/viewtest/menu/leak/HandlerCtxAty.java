package com.fuck.viewtest.menu.leak;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

import java.lang.ref.WeakReference;

//ABC
public class HandlerCtxAty extends AppCompatActivity implements View.OnClickListener {

    private final MyHandler mMyHandler = new MyHandler(this, Looper.myLooper());

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

    //使用静态Handler类，防止Handler对象持有Activity的this引用
    static class MyHandler extends Handler {
        //使用弱引用，指向Context对象
        private WeakReference<Context> mContextRef = null;

        public MyHandler(Context pContext, Looper pLooper) {
            super(pLooper);
            if (mContextRef == null) {
                mContextRef = new WeakReference<Context>(pContext);
            }
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Context context = mContextRef.get();
            switch (msg.what) {
                case 1: {
                    Toast.makeText(context, "收到消息", Toast.LENGTH_SHORT).show();
                }
                case 2: {
                    Toast.makeText(context, "fuckU", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
