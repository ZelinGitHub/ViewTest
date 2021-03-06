package com.fuck.viewtest.menu.view_.cusview.viewcontructor;

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
    private final Paint mPaint = new Paint();

    //重写构造方法1
    //使用this调用构造方法2，参数AttributeSet传null
    public Vegetable(Context context) {
        this(context, null);
    }

    //重写构造方法2
    //使用this调用构造方法3
    //参数3传入默认风格属性资源ID，没有默认风格属性时传0
    public Vegetable(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.vegetableDefStyle);
    }

    //重写构造方法3
    //使用this调用构造方法4
    //参数4传入默认风格资源ID，没有默认风格传0
    public Vegetable(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, R.style.vegetableStyle3);
    }

    //重写构造方法4
    //必须使用super调用父类View的构造方法
    //解析AttributeSet
    //解析TypedArray
    //回收TypedArray
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
