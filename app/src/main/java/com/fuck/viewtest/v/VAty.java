package com.fuck.viewtest.v;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class VAty extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v);
        initViews();
        initUI();
    }


    private void initViews() {
        v = findViewById(R.id.v);
    }

    private void initUI() {

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        System.out.println("View坐标："+v.getLeft()+" "+v.getTop()+" "+v.getRight()+" "+v.getBottom());
        System.out.println("View偏移后坐标："+v.getX()+" "+v.getY());
        System.out.println("开始偏移");
        v.setX(500);
        v.setY(500);
        System.out.println("偏移结束");
        System.out.println("View坐标："+v.getLeft()+" "+v.getTop()+" "+v.getRight()+" "+v.getBottom());
        System.out.println("View偏移后坐标："+v.getX()+" "+v.getY());

    }
}
