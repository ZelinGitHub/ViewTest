package com.fuck.viewtest.menu.view_.cusview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class NormalGestureTrackView extends View {
    private Path mPath=new Path();
    private Paint mPaint=new Paint();
    public NormalGestureTrackView(Context context) {
        this(context,null);
    }

    public NormalGestureTrackView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NormalGestureTrackView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                mPath.moveTo(x,y);
                return true;
            }
            case MotionEvent.ACTION_MOVE:{
                mPath.lineTo(x,y);
                invalidate();
                break;
            }
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(mPath,mPaint);
    }
}
