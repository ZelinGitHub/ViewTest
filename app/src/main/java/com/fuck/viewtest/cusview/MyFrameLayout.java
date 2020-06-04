package com.fuck.viewtest.cusview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyFrameLayout extends FrameLayout {
    public MyFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {

//            case MotionEvent.ACTION_DOWN:{
//                System.out.println("MyFrameLayout 拦截 ACTION_DOWN");
//                return true;
//            }
            case MotionEvent.ACTION_MOVE: {
                System.out.println("MyFrameLayout 拦截 ACTION_MOVE");
                return true;
            }
//            case MotionEvent.ACTION_UP: {
//                System.out.println("MyFrameLayout 拦截 ACTION_UP");
//                return true;
//            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                System.out.println("MyFrameLayout 处理 ACTION_DOWN");
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                System.out.println("MyFrameLayout 处理 ACTION_MOVE");
                return true;
            }

            case MotionEvent.ACTION_UP: {
                System.out.println("MyFrameLayout 处理 ACTION_UP");
                return true;
            }
            case MotionEvent.ACTION_CANCEL: {
                System.out.println("MyFrameLayout 处理 ACTION_CANCEL");
                return true;
            }
        }
        return super.onTouchEvent(event);
    }
}
