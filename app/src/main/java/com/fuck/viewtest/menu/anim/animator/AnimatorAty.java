package com.fuck.viewtest.menu.anim.animator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.anim.animator.evaluator.ColorEvaluator;

public class AnimatorAty extends AppCompatActivity {

    TextView tv_hello;
    Button btn_start_anim;
    PointView pv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);

        initViews();
        initUI();

    }

    private void initViews() {
        tv_hello = findViewById(R.id.tv_hello);
        btn_start_anim = findViewById(R.id.btn_start_anim);
        pv = findViewById(R.id.pv);
    }

    private void initUI() {
        tv_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btn_start_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    //在5秒中内从常规变换成全透明，再从全透明变换成常规
    public void startViewObjectAnimatorAlpha() {
        Animator animator = ObjectAnimator.ofFloat(tv_hello, "alpha", 1f, 0f, 1f);
        animator.setDuration(5000);
        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animator.addListener(new AnimatorListenerAdapter() {
        });
        animator.start();
    }

    //先向左移出屏幕，然后再移动回来
    public void startViewObjectAnimatorTranslation() {
        float beginX = tv_hello.getTranslationX();
        Animator animator = ObjectAnimator.ofFloat(tv_hello, "translationX", beginX, -500f, beginX);
        animator.setDuration(5000);
        animator.start();
    }

    //进行一次360度的旋转
    public void startViewObjectAnimatorRotate() {
        Animator animator = ObjectAnimator.ofFloat(tv_hello, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.start();
    }


    //在垂直方向上放大3倍再还原
    public void startViewObjectAnimatorScale() {
        Animator animator = ObjectAnimator.ofFloat(tv_hello, "scaleY", 1f, 3f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    //在平移之后，播放旋转，同时执行透明度改变，
    public void startViewAnimatorSet() {
        //动画 平移
        Animator moveIn = ObjectAnimator.ofFloat(tv_hello, "translationX", -500f, 0f);
        //动画 旋转
        Animator rotate = ObjectAnimator.ofFloat(tv_hello, "rotation", 0f, 360f);
        //动画 透明度改变
        Animator fadeInOut = ObjectAnimator.ofFloat(tv_hello, "alpha", 1f, 0f, 1f);
        //动画集合
        AnimatorSet animatorSet = new AnimatorSet();
        //
        animatorSet.play(rotate).with(fadeInOut).after(moveIn);
        animatorSet.setDuration(5000);
        animatorSet.start();

    }

    public void startViewPropertyAnimatorAlpha() {
        tv_hello.animate().alpha(0f);
    }

    public void startPointViewObjectAnimatorColor() {
        TypeEvaluator<String> typeEvaluator = new ColorEvaluator();
        Animator anim = ObjectAnimator.ofObject(
                pv, "color", typeEvaluator,
                "#0000FF", "#FF0000"
        );
        anim.setDuration(5000);
        anim.start();
    }
}
