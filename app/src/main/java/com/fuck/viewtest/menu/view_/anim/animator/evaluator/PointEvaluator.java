package com.fuck.viewtest.menu.view_.anim.animator.evaluator;

import android.animation.TypeEvaluator;

import com.fuck.viewtest.menu.view_.anim.animator.MyPoint;

public class PointEvaluator implements TypeEvaluator<MyPoint> {
    @Override
    public MyPoint evaluate(float fraction, MyPoint startValue, MyPoint endValue) {

        //起始
        float x1 = startValue.getX();
        float y1 = startValue.getY();

        //结束
        float x2 = endValue.getX();
        float y2 = endValue.getY();

        //当前
        float x = x1 + fraction * (x2 - x1);
        float y = y1 + fraction * (y2 - y1);

        return new MyPoint(x, y);
    }
}
