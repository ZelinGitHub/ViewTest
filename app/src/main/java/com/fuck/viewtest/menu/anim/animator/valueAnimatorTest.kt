package com.fuck.viewtest.menu.anim.animator

import android.animation.ValueAnimator
import com.fuck.viewtest.menu.anim.animator.evaluator.PointEvaluator


/**
 * 值动画
 * 值动画测试
 */
fun valueAnimatorTest(){
    //要将一个值，从0平滑过渡到1
    val valueAnimator= ValueAnimator.ofFloat(0f,1f)
    //动画时长300毫秒
    valueAnimator.duration = 300
    //开启动画
    //值在300毫秒的时间内从0平滑过渡到了1
    valueAnimator.start()
}

fun valueAnimatorListenerTest(){
    val valueAnimator= ValueAnimator.ofFloat(0f,1f)
    valueAnimator.duration = 300
    //为值动画添加监听器
    valueAnimator.addUpdateListener {
        println(it.animatedValue)
    }
    valueAnimator.start()
}



fun valueAnimatorMoreParamTest(){
    //ofFloat()方法当中是可以传入任意多个参数的
    //将一个值在5秒内从0过渡到5，再过渡到3，再过渡到10
    val valueAnimator= ValueAnimator.ofFloat(0f,5f,3f,10f)
    valueAnimator.duration = 5000
    valueAnimator.start()
}


fun valueAnimatorIntTest(){
    //不需要小数位数的动画过渡，将一个整数值从0平滑地过渡到100
    val valueAnimator= ValueAnimator.ofInt(0,100)
    valueAnimator.duration = 2000
    valueAnimator.start()
}

fun valueAnimatorObjectTest(){
    val point1 = MyPoint(0f, 0f)
    val point2 = MyPoint(300f, 300f)
    //调用ValueAnimator的ofObject()方法来构建ValueAnimator的实例
    //ofObject()方法要求多传入一个TypeEvaluator参数
    val valueAnimator = ValueAnimator.ofObject(PointEvaluator(), point1, point2)
    valueAnimator.duration = 5000
    valueAnimator.start()
}
