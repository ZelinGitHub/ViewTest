package com.fuck.viewtest.menu.anim.animator

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fuck.viewtest.R
import kotlinx.android.synthetic.main.activity_animator.*


class AnimatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animator)


    }


    fun tvAlphaTest() {
        //ObjectAnimator会帮我们不断地改变textView对象中alpha属性的值
        //将一个TextView在5秒中内从常规变换成全透明，再从全透明变换成常规
        //这里第一个参数要求传入一个object对象，表示要对哪个对象进行动画操作
        //第二个参数是想要对该对象的哪个属性进行动画操作
        //我们想要改变TextView的透明度，这里传入"alpha"
        //后面的参数就是不固定长度了，想要完成什么样的动画就传入什么值
        //这里传入的值就表示将TextView从常规变换成全透明，再从全透明变换成常规
        val objectAnimator = ObjectAnimator.ofFloat(tv_hello, "alpha", 1f, 0f, 1f)
        //调用setDuration()方法来设置动画的时长
        objectAnimator.duration = 5000
        //调用start()方法启动动画
        objectAnimator.start()
    }

    fun tvRotationTest() {
        //将TextView进行一次360度的旋转
        val objectAnimator = ObjectAnimator.ofFloat(tv_hello, "rotation", 0f, 360f)
        objectAnimator.duration = 5000;
        objectAnimator.start();
    }

    fun tvTranslationTest() {
        //将TextView先向左移出屏幕，然后再移动回来
        val beginX = tv_hello.translationX
        val objectAnimator = ObjectAnimator.ofFloat(tv_hello, "translationX", beginX, -500f, beginX)
        objectAnimator.duration = 5000;
        objectAnimator.start();

    }

    fun tvScaleTest() {
        //将TextView在垂直方向上放大3倍再还原
        val objectAnimator = ObjectAnimator.ofFloat(tv_hello, "scaleY", 1f, 3f, 1f)
        objectAnimator.duration = 5000
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
}
