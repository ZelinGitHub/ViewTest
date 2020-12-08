package com.fuck.viewtest.seria;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_serial;
    private Button btn_anti_serial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial);
        initViews();
        initUI();
    }


    private void initViews() {
        btn_serial = findViewById(R.id.btn_serial);
        btn_anti_serial = findViewById(R.id.btn_anti_serial);
    }

    private void initUI() {
        btn_serial.setOnClickListener(this);
        btn_anti_serial.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_serial: {
                break;
            }
            case R.id.btn_anti_serial: {
                break;
            }
        }
    }


}
