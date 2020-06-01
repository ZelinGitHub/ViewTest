package com.fuck.viewtest.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.fuck.viewtest.R;

public class MyPath extends View {
    ViewGroup v;
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
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(500);

        mRectF.left = 100;
        mRectF.top = 200;
        mRectF.right = 600;
        mRectF.bottom = 1000;

        mRectF2.left = 200;
        mRectF2.top = 300;
        mRectF2.right = 1100;
        mRectF2.bottom = 1200;

        canvas.drawArc(mRectF,0,225,false,mPaint);
    }
}
