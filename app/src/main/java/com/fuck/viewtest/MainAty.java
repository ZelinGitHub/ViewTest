package com.fuck.viewtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.anim.AnimAty;
import com.fuck.viewtest.vp.VpAty;
import com.fuck.viewtest.win.WinAty;

public class MainAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_vp;
    private Button btn_anim;
    private Button btn_win;

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
    }


    private void initUI() {
        btn_vp.setOnClickListener(this);
        btn_anim.setOnClickListener(this);
        btn_win.setOnClickListener(this);
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
        }
    }
}
