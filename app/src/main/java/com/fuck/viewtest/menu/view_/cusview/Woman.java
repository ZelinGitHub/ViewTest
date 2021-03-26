package com.fuck.viewtest.menu.view_.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Woman extends View {
    private Paint mPaint=new Paint();
    public Woman(Context context) {
        this(context,null);
    }

    public Woman(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Woman(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int height = getHeight() - getPaddingTop() - getPaddingBottom();
        canvas.drawRect(
                0F + getPaddingLeft()
                , 0F + getPaddingTop()
                , width + getPaddingRight()
                , height + getPaddingBottom()
                , mPaint);
    }
}
