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
//        canvas.drawColor(getResources().getColor(R.color.colorPrimary));
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPath.moveTo(0, 0);
//        mPath.lineTo(800,1500);
//        mPath.lineTo(300,1600);
//        mPath.close();
//        mPath.setFillType(Path.FillType.INVERSE_EVEN_ODD);
//        mPath.quadTo(60,1500,getWidth(),getHeight());
//        mPath.addCircle(getWidth()/2F,getHeight()/2F,300, Path.Direction.CCW);
        mRectF.left = 100;
        mRectF.top = 200;
        mRectF.right = 600;
        mRectF.bottom = 1000;

        mRectF2.left = 200;
        mRectF2.top = 300;
        mRectF2.right = 1100;
        mRectF2.bottom = 1200;


//        mPath.addRect(mRectF2, Path.Direction.CCW);
//        mPath.addCircle(getWidth()/2F,getHeight()/2F,300, Path.Direction.CCW);
//        mPath.addOval(mRectF2, Path.Direction.CW);
//        mPath.addArc(mRectF2,220,-120);
//        mPath.addRoundRect(mRectF2, 10, 15, Path.Direction.CCW);
        mPath.arcTo(mRectF, 90, 180);

//        mPath.moveTo(200,200);
//        mPath.lineTo(500, 1200);
        mPath.lineTo(900, 1000);


        mPath.close();
        canvas.drawPath(mPath, mPaint);
//        mPaint.setTextSize(50);
//        canvas.drawTextOnPath("012345678910111213141516171819", mPath, 0, 0, mPaint);
    }
}
