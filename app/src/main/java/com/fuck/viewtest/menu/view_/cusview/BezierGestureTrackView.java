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

public class BezierGestureTrackView extends View {
    private Path mPath=new Path();
    private Paint mPaint=new Paint();
    private float mPreX;
    private float mPreY;

    public BezierGestureTrackView(Context context) {
        this(context,null);
    }

    public BezierGestureTrackView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BezierGestureTrackView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
                mPreX=x;
                mPreY=y;
                return true;
            }
            case MotionEvent.ACTION_MOVE:{
                float endX=(mPreX+x)/2;
                float endY=(mPreY+y)/2;
                mPath.quadTo(mPreX,mPreY,endX,endY);
                mPreX=x;
                mPreY=y;
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
