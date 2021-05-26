package com.fuck.viewtest.menu.view_.cusview.line;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class InvalidTextView extends androidx.appcompat.widget.AppCompatTextView {

    private final Paint mPaint = new Paint();

    public InvalidTextView(Context context) {
        this(context, null);
    }

    public InvalidTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InvalidTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float leftX = 0F;
        float leftY = getHeight() / 2F;
        float rightX = getWidth();
        float rightY = getHeight() / 2F;
        canvas.drawLine(leftX, leftY, rightX, rightY, mPaint);
    }

    private void initPaint() {
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4F);
    }


}
