package com.fuck.viewtest.menu.anim.animator

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.AccelerateInterpolator


class MyAnimView(context: Context, attrs: AttributeSet) : View(context, attrs) {

    private var mCurrentPoint: Point? = null

    private val mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var color:String=""
    set(value) {
        field=value
        mPaint.color=Color.parseColor(field)
        invalidate()
    }

    init {
        mPaint.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas) {
        if (mCurrentPoint == null) {
            //当前点的初始值
            mCurrentPoint = Point(RADIUS, RADIUS)
            //开启动画
            startAnimation()
        }
        //用point的x和y坐标绘制图形
        val x = mCurrentPoint!!.x
        val y = mCurrentPoint!!.y
        canvas.drawCircle(x, y, RADIUS, mPaint)
    }



    /**
     * 开启Point的动画
     */
    private fun startAnimation() {
        val startPoint = Point(RADIUS, RADIUS)
        val endPoint = Point(width - RADIUS, height - RADIUS)
        val anim = ValueAnimator.ofObject(PointEvaluator(), startPoint, endPoint)
        anim.addUpdateListener { animation ->
            //更新当前点的值
            mCurrentPoint = animation.animatedValue as Point
            //重绘
            invalidate()
        }
        //设置动画的插值器
        //AccelerateInterpolator是加速运动插值器
        //参数用来控制加速度
        anim.interpolator = AccelerateInterpolator(2f);
        //动画执行五秒
        anim.duration = 5000
        anim.start()
    }



}