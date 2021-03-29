package com.fuck.viewtest.menu.window;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class WinAty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_window;
    private Button btn_popupwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        initViews();
        initUI();

    }

    private void initViews() {
        btn_window = findViewById(R.id.btn_window);
        btn_popupwindow = findViewById(R.id.btn_popupwindow);
    }

    private void initUI() {
        btn_window.setOnClickListener(this);
        btn_popupwindow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_window: {
                Intent intent = new Intent(this, WindowAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_popupwindow: {
                Intent intent = new Intent(this, PopupWindowAty.class);
                startActivity(intent);
                break;
            }
        }
    }



}
