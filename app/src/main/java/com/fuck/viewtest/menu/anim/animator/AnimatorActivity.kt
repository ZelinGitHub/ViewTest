package com.fuck.viewtest.menu.anim.animator

import android.animation.*
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fuck.viewtest.R


class AnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator)
    }




    fun tvScaleTest() {
        //将TextView

        objectAnimator.addListener(object : Animator.AnimatorListener {
            //onAnimationRepeat()方法会在动画重复执行的时候调用
            override fun onAnimationRepeat(p0: Animator?) {

            }

            //onAnimationEnd()方法会在动画结束的时候调用
            override fun onAnimationEnd(p0: Animator?) {
            }

            //onAnimationCancel()方法会在动画被取消的时候调用
            override fun onAnimationCancel(p0: Animator?) {
            }

            //onAnimationStart()方法会在动画开始的时候调用
            override fun onAnimationStart(p0: Animator?) {
            }

        })

        objectAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
            }
        })
        objectAnimator.start()
    }

    fun tvAnimatorSetTest() {
        //动画 平移
        val moveIn = ObjectAnimator.ofFloat(tv_hello, "translationX", -500f, 0f)
        //动画 旋转
        val rotate = ObjectAnimator.ofFloat(tv_hello, "rotation", 0f, 360f)
        //动画 透明度改变
        val fadeInOut = ObjectAnimator.ofFloat(tv_hello, "alpha", 1f, 0f, 1f)
        //动画集合
        val animatorSet = AnimatorSet()
        //在平移之后，播放旋转，同时执行透明度改变，
        animatorSet.play(rotate).with(fadeInOut).after(moveIn)
        animatorSet.duration = 5000
        animatorSet.start()


    }


    fun mavColorAnimatorTest() {
        //对象动画的ofObject方法
        //参数1是自定义控件的对象
        //参数2是自定义控件对象的属性
        //参数3是估值器对象
        val anim = ObjectAnimator.ofObject(
                mav, "color", ColorEvaluator(),
                "#0000FF", "#FF0000"
        )
        anim.duration = 5000
        anim.start()
    }

    fun viewPropertyAnimatorTest() {
        tv_hello.animate().alpha(0f)
    }

//    private fun initAnimator() {
//        val animator = ValueAnimator.ofInt(0, 400)
//        animator.duration = 1000
//        animator.addUpdateListener { animation ->
//            val curValue = animation.animatedValue as Int
//            v.layout(curValue, curValue, curValue + v.getWidth(), curValue + v.getHeight())
//        }
//        animator.start()
//    }
}
