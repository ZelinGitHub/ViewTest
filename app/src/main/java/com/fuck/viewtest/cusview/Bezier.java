package com.fuck.viewtest.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Bezier extends View {
    private Path mPath=new Path();
    private RectF mRectF=new RectF();

    public Bezier(Context context) {
        this(context,null);
    }

    public Bezier(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Bezier(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPath.quadTo(0,0,getWidth(),getHeight());
        mRectF.left=50;
        mRectF.top=50;
        mRectF.right=300;
        mRectF.bottom=300;
        mPath.arcTo(mRectF,90,180);
    }
}
