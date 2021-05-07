package com.fuck.viewtest.menu.codeframe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.codeframe.mvp.MvpAty;
import com.fuck.viewtest.menu.codeframe.mvvm.MvvmAty;

//ABC
public class CodeFrameAty extends AppCompatActivity {


    private Button btn_aac;
    private Button btn_mvp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_frame);
        initViews();
        initUI();
    }


    private void initViews() {
        btn_aac = findViewById(R.id.btn_aac);
        btn_mvp = findViewById(R.id.btn_mvp);
    }


    private void initUI() {
        //局部类
        class MyOnClickListener1 implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                toMvvmAty();
            }
        }
        //局部类
        class MyOnClickListener2 implements View.OnClickListener {

            @Override
            public void onClick(View v) {
                toMvpAty();
            }
        }
        MyOnClickListener1 myOnClickListener1 = new MyOnClickListener1();
        MyOnClickListener2 myOnClickListener2 = new MyOnClickListener2();

        btn_aac.setOnClickListener(myOnClickListener1);
        btn_mvp.setOnClickListener(myOnClickListener2);
    }


    private void toMvvmAty() {
        Intent intent = new Intent(this, MvvmAty.class);
        startActivity(intent);
    }

    private void toMvpAty() {
        Intent intent = new Intent(this, MvpAty.class);
        startActivity(intent);
    }
}
