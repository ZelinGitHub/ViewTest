package com.fuck.viewtest.v;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

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
        moveView();
    }

    private void moveView() {
        System.out.println("View原始坐标：" + v.getLeft() + " " + v.getTop() + " " + v.getRight() + " " + v.getBottom());
        System.out.println("View当前坐标：" + v.getX() + " " + v.getY());
        v.setX(500);
        v.setY(500);
        System.out.println("View原始坐标：" + v.getLeft() + " " + v.getTop() + " " + v.getRight() + " " + v.getBottom());
        System.out.println("View当前坐标：" + v.getX() + " " + v.getY());
        v.setTranslationX(200);
        v.setTranslationY(200);
        System.out.println("View原始坐标：" + v.getLeft() + " " + v.getTop());
        System.out.println("View当前坐标：" + v.getX() + " " + v.getY());
        v.setTranslationX(200);
        v.setTranslationY(1200);
        System.out.println("View原始坐标：" + v.getLeft() + " " + v.getTop());
        System.out.println("View当前坐标：" + v.getX() + " " + v.getY());

        v.offsetLeftAndRight(300);
        v.offsetTopAndBottom(300);
        System.out.println("View原始坐标：" + v.getLeft() + " " + v.getTop());
        System.out.println("View当前坐标：" + v.getX() + " " + v.getY());

    }



}
