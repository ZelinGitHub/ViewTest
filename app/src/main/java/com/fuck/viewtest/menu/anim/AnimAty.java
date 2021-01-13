package com.fuck.viewtest.menu.anim;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class AnimAty extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        v = findViewById(R.id.v);
        initAnimation();
        initAnimator();
    }


    private void initAnimation() {
        TranslateAnimation animation = new TranslateAnimation(
                0
                , 800
                , 0
                , 1000
        );

        animation.setDuration(2000);
        AccelerateDecelerateInterpolator interpolator=new AccelerateDecelerateInterpolator();
        animation.setInterpolator(interpolator);
        v.startAnimation(animation);
    }


    private void initAnimator() {
        ValueAnimator animator=ValueAnimator.ofInt(0,400);
        animator.setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue= (Integer) animation.getAnimatedValue();
                v.layout(curValue,curValue,curValue+v.getWidth(),curValue+v.getHeight());
            }
        });
        animator.start();
    }
}
