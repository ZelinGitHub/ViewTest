package com.fuck.viewtest.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.fuck.viewtest.R;

public class MyPath extends View {
    private RectF mRectF = new RectF();
    private RectF mRectF2 = new RectF();

    private Path mPath = new Path();
    private Paint mPaint = new Paint();

    public MyPath(Context context) {
        this(context, null);
    }

    public MyPath(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyPath(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MyPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

        drawArcPath(canvas);
        drawLinePath(canvas);

    }

    private void drawLinePath(Canvas pCanvas) {
//        mPath.lineTo(500,1000);
        mPath.lineTo(500,1200);
        pCanvas.drawPath(mPath,mPaint);
    }

    private void drawArcPath(Canvas pCanvas) {
        mRectF.left = 100;
        mRectF.top = 200;
        mRectF.right = 600;
        mRectF.bottom = 1000;

        mRectF2.left = 500;
        mRectF2.top = 800;
        mRectF2.right = 800;
        mRectF2.bottom = 1400;

        mPath.arcTo(mRectF,0,120);
//        mPath.arcTo(mRectF2,90,270);
        pCanvas.drawPath(mPath,mPaint);
    }

    private void addCirclePath(Canvas pCanvas){
        mPath.addCircle(500,900,200, Path.Direction.CW);
        pCanvas.drawPath(mPath,mPaint);
    }
}
