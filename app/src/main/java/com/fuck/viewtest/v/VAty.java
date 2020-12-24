package com.fuck.viewtest.v;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

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

        viewPost();


        viewTreeObserver();


        getSize();


        getSite();

        layout();


        offset();

    }

    private void offset() {
        v.offsetLeftAndRight(200);
        v.offsetTopAndBottom(300);
    }

    private void layout() {
        int offsetX = 100;
        int offsetY = 200;

        v.layout(
                v.getLeft() + offsetX
                , v.getTop() + offsetY
                , v.getRight() + offsetX
                , v.getBottom() + offsetY
        );

    }


    private void getSite() {
        int left = v.getLeft();
        int top = v.getTop();
        int right = v.getRight();
        int bottom = v.getBottom();
    }

    private void getSize() {
        int width = v.getRight() - v.getLeft();
        int height = v.getBottom() - v.getTop();
        int width2 = v.getWidth();
        int height2 = v.getHeight();
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


    private void viewPost() {
        v.post(new Runnable() {
            @Override
            public void run() {
                int measureWidth = v.getMeasuredWidth();
                int measureHeight = v.getMeasuredHeight();
                int width = v.getWidth();
                int height = v.getHeight();
            }
        });
    }

    private void viewTreeObserver() {
        ViewTreeObserver observer = v.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                v.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int measureWidth = v.getMeasuredWidth();
                int measureHeight = v.getMeasuredHeight();
                int width = v.getWidth();
                int height = v.getHeight();
            }
        });
    }

}
