package com.fuck.viewtest.menu.mvvm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.mvvm.dragonx.DragonXAty;
import com.fuck.viewtest.menu.mvvm.geng.GenGAty;
import com.fuck.viewtest.menu.mvvm.rng.RngAty;
import com.fuck.viewtest.menu.mvvm.rng2.Rng2Aty;

public class MvvmAty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_to_dragon_x;
    private Button btn_to_gen_g;
    private Button btn_to_rng;
    private Button btn_to_rng2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        initView();
        initUI();
    }

    private void initView() {

        btn_to_dragon_x = findViewById(R.id.btn_to_dragon_x);
        btn_to_gen_g = findViewById(R.id.btn_to_gen_g);
        btn_to_rng = findViewById(R.id.btn_to_rng);
        btn_to_rng2 = findViewById(R.id.btn_to_rng2);
    }

    private void initUI() {
        btn_to_dragon_x.setOnClickListener(this);
        btn_to_gen_g.setOnClickListener(this);
        btn_to_rng.setOnClickListener(this);
        btn_to_rng2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_to_dragon_x:{
                Intent intent = new Intent(this, DragonXAty.class);
                startActivity(intent);
            }
            case R.id.btn_to_gen_g:{
                Intent intent = new Intent(this, GenGAty.class);
                startActivity(intent);
            }
            case R.id.btn_to_rng:{
                Intent intent = new Intent(this, RngAty.class);
                startActivity(intent);
            }
            case R.id.btn_to_rng2:{
                Intent intent = new Intent(this, Rng2Aty.class);
                startActivity(intent);
            }
        }
    }


}
