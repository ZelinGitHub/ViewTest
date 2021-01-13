package com.fuck.viewtest.menu.cusview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(Context context) {
        this(context, null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthDefaultSize = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        int heightDefaultSize = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);

        if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(100, 100);
        } else if (widthMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(100, heightDefaultSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthDefaultSize, 100);
        } else {
            setMeasuredDimension(widthDefaultSize, heightDefaultSize);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                System.out.println("MyView 处理 ACTION_DOWN");
                return true;
            }
            case MotionEvent.ACTION_MOVE: {
                System.out.println("MyView 处理 ACTION_MOVE");
                return true;
            }
            case MotionEvent.ACTION_UP: {
                System.out.println("MyView 处理 ACTION_UP");
                return true;
            }
            case MotionEvent.ACTION_CANCEL: {
                System.out.println("MyView 处理 ACTION_CANCEL");
                return true;
            }
        }
        return super.onTouchEvent(event);
    }
}
