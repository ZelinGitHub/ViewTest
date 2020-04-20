package com.fuck.viewtest.anim;

import android.animation.ObjectAnimator;
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
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0F, 1F);
        ValueAnimator valueAnimator1 = ValueAnimator.ofFloat(0F, 5F, 3F, 10F);
        ValueAnimator valueAnimator2 = ValueAnimator.ofInt(0, 100);

        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(
                v
                , "translationX"
                , 0
                , 800
        );

        AccelerateDecelerateInterpolator interpolator=new AccelerateDecelerateInterpolator();
        valueAnimator.setInterpolator(interpolator);

    }
}
