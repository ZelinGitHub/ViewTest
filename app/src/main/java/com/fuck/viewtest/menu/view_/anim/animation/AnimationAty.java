package com.fuck.viewtest.menu.view_.anim.animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class AnimationAty extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        v = findViewById(R.id.v);
        initAnimation();
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



}
