package com.fuck.viewtest.menu.view_.cusview.bezier;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.fuck.viewtest.R;

public class BezierView extends View {
    private final Path mPath = new Path();
    private final RectF mRectF = new RectF();
    private final Paint mPaint = new Paint();

    public BezierView(Context context) {
        this(context, null);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BezierView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas pCanvas) {
        super.onDraw(pCanvas);
        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);

//        mPath.moveTo(200,200);
        mPath.lineTo(600, 700);
        mPath.quadTo(0, getHeight(), getWidth() - 200, getHeight() - 200);

        mRectF.left = 50;
        mRectF.top = 50;
        mRectF.right = 300;
        mRectF.bottom = 300;
//        mPath.arcTo(mRectF,90,180);
        pCanvas.drawPath(mPath, mPaint);

    }
}
