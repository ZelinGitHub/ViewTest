package com.fuck.viewtest.menu.anim.animator

import android.animation.TypeEvaluator
import com.fuck.viewtest.menu.anim.animator.Point


class PointEvaluator:TypeEvaluator<Point> {

    override fun evaluate(pFraction: Float, pStartValue: Point, pEndValue: Point): Point {
        //解构声明
        val (x1, y1) = pStartValue
        //解构声明
        val (x2, y2) = pEndValue
        //当前进度
        val x = x1 + pFraction * (x2 - x1)
        //当前进度
        val y = y1 + pFraction * (y2 - y1)
        //动画当前值
        return Point(x, y)
    }
}