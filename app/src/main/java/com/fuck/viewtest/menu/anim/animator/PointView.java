package com.fuck.viewtest.menu.anim.animator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;

import androidx.annotation.Nullable;

import com.fuck.viewtest.menu.anim.animator.evaluator.PointEvaluator;

public class PointView extends View {
    private MyPoint mPoint;

    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public static final float RADIUS = 50F;

    public PointView(Context context) {
        this(context, null);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mPaint.setColor(Color.BLUE);
    }


    public void setColor(String pColor) {
        mPaint.setColor(Color.parseColor(pColor));
        invalidate();
    }

    //用point的x和y坐标绘制一个圆
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPoint == null) {
            //当前点的初始值
            mPoint = new MyPoint(RADIUS, RADIUS);
            //开启动画
            startAnimation();
        }

        float x = mPoint.getX();
        float y = mPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }


    /**
     * 开启Point的动画
     */
    private void startAnimation() {
        MyPoint startPoint = new MyPoint(RADIUS, RADIUS);
        MyPoint endPoint = new MyPoint(getWidth() - RADIUS, getHeight() - RADIUS);
        PointEvaluator pointEvaluator = new PointEvaluator();
        ValueAnimator valueAnimator = ValueAnimator.ofObject(pointEvaluator, startPoint, endPoint);

        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mPoint= (MyPoint) animation.getAnimatedValue();
                invalidate();
            }
        });
        //设置插值器
        //AccelerateInterpolator是加速运动插值器，参数用来控制加速度
        valueAnimator.setInterpolator(new AccelerateInterpolator(2f));
        //动画执行五秒
        valueAnimator.setDuration(5000);
        valueAnimator.start();
    }

}
