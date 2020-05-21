package com.fuck.viewtest.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.fuck.viewtest.R;

public class MyPath extends View {
    ViewGroup v;

    private Path mPath=new Path();
    private Paint mPaint=new Paint();

    public MyPath(Context context) {
        this(context,null);
    }

    public MyPath(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public MyPath(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public MyPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setAntiAlias(true);
        canvas.drawColor(getResources().getColor(R.color.colorPrimary));
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
//        mPath.moveTo(0,0);
//        mPath.lineTo(800,1500);
//        mPath.lineTo(300,1600);
//        mPath.close();
//        mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
        mPath.quadTo(60,1500,getWidth(),getHeight());
        canvas.drawPath(mPath,mPaint);
    }
}
