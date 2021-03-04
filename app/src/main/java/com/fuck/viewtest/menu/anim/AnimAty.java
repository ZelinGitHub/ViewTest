package com.fuck.viewtest.menu.anim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.anim.animation.AnimationAty;
import com.fuck.viewtest.menu.anim.animator.AnimatorAty;

public class AnimAty extends AppCompatActivity implements View.OnClickListener {

    private View btn_animation;
    private View btn_animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim);
        initViews();
        initUI();
    }


    private void initViews() {
        btn_animation = findViewById(R.id.btn_animation);
        btn_animator = findViewById(R.id.btn_animator);
    }


    private void initUI() {
        btn_animation.setOnClickListener(this);
        btn_animator.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_animation: {
                Intent intent = new Intent(this, AnimationAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_animator: {
                Intent intent = new Intent(this, AnimatorAty.class);
                startActivity(intent);
                break;
            }
        }
    }
}
