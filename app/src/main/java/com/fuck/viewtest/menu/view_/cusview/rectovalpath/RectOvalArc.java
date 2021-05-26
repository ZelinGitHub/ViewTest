package com.fuck.viewtest.menu.view_.cusview.rectovalpath;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.fuck.viewtest.R;

public class RectOvalArc extends View {
    private final Paint mPaint = new Paint();
    private final RectF mRect = new RectF();

    public RectOvalArc(Context context) {
        super(context);
    }

    public RectOvalArc(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RectOvalArc(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(getContext().getResources().getColor(R.color.redffff534BPrimary));
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mRect.set(250, 450, 1000, 1800);
        canvas.drawRect(mRect, mPaint);

        mPaint.setColor(getContext().getResources().getColor(R.color.blueff0d79cdPrimary));
        canvas.drawArc(mRect,0,120,false,mPaint);

        mPaint.setColor(getContext().getResources().getColor(R.color.orange_ringffff9434));
        canvas.drawOval(mRect,mPaint);

        canvas.drawCircle(0,0,100,mPaint);

        canvas.drawPoint(0,0,mPaint);
        canvas.drawLine(0,0,1,1,mPaint);

        canvas.drawRGB(0,1,2);
        canvas.drawARGB(0,1,2,3);
        canvas.drawColor(0xFFFFFFFF);
    }

}
