package com.fuck.viewtest.menu.view_.anim.animation;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;

import com.fuck.viewtest.R;

import androidx.appcompat.app.AppCompatActivity;

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
        AccelerateDecelerateInterpolator interpolator = new AccelerateDecelerateInterpolator();
        animation.setInterpolator(interpolator);
        v.startAnimation(animation);
    }


    private void loadAnimation(Context pContext) {
        Animation animation = AnimationUtils.loadAnimation(pContext, R.anim.anim_w);
    }

}
