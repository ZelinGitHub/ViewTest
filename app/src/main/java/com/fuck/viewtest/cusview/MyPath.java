package com.fuck.viewtest.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.fuck.viewtest.R;

public class MyPath extends View {
    ViewGroup v;

    private Path mPath=new Path();
    private Paint mPaint=new Paint();
    public MyPath(Context context) {
        super(context);
    }

    public MyPath(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyPath(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawColor(getResources().getColor(R.color.colorPrimary));
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);
        mPath.moveTo(0,0);
        mPath.lineTo(800,100);
        canvas.drawPath(mPath,mPaint);
        canvas.drawLine(0,0,200,200,mPaint);
    }
}
