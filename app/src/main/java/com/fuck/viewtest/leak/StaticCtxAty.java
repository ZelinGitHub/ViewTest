package com.fuck.viewtest.leak;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

//ABC
public class StaticCtxAty extends AppCompatActivity implements View.OnClickListener {

    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_ctx);
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
        mContext = this;
    }


}
