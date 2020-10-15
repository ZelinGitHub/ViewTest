package com.fuck.viewtest.leak;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

//ABC
public class LeakTestAty extends AppCompatActivity implements View.OnClickListener {


//    private static ABC sABC=new ABC();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leak_test);
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

    }

    class ABC {

    }

}
