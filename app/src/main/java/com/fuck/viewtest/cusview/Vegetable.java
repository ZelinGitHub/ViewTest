package com.fuck.viewtest.cusview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.fuck.viewtest.R;

public class Vegetable extends View {

    private String mTitle = "";
    private int mBack = 0xFF000000;
    private Paint mPaint = new Paint();

    public Vegetable(Context context) {
        super(context);
    }

    public Vegetable(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.vegetableDefStyle);
    }
    public Vegetable(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, R.style.vegetableStyle3);
    }
    public Vegetable(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        //解析AttributeSet
        //得到指定属性组
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Vegetable, defStyleAttr, defStyleRes);
        //解析属性值
        mBack = typedArray.getColor(R.styleable.Vegetable_back, 0xFF000000);
        //解析属性值
        mTitle = typedArray.getString(R.styleable.Vegetable_title);
        //回收TypedArray
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //得到规格模式
        int widthSpecMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = View.MeasureSpec.getMode(heightMeasureSpec);

        //设置wrapContent尺寸为200
        if (widthSpecMode == View.MeasureSpec.AT_MOST && heightSpecMode == View.MeasureSpec.AT_MOST) {
            setMeasuredDimension(500, 500);
        } else if (widthSpecMode == View.MeasureSpec.AT_MOST) {
            int defaultHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
            setMeasuredDimension(500, defaultHeight);
        } else if (heightSpecMode == View.MeasureSpec.AT_MOST) {
            int defaultWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
            setMeasuredDimension(defaultWidth, 500);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(mBack);
        if (mTitle != null) {
            mPaint.setColor(0xFFFFFFFF);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setTextSize(100);
            mPaint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(mTitle, (float) getWidth() / 2, (float) getHeight() / 2, mPaint);
        }
    }


}
