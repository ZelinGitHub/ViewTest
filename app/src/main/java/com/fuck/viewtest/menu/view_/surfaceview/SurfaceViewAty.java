package com.fuck.viewtest.menu.view_.surfaceview;

import android.os.Bundle;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class SurfaceViewAty extends AppCompatActivity {

    private SurfaceView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surfaceview);
        initViews();
        initUI();
    }


    private void initViews() {
        sv = findViewById(R.id.sv);
    }

    private void initUI() {

    }


}
