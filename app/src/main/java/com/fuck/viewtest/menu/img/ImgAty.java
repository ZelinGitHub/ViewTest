package com.fuck.viewtest.menu.img;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.img.bitmap.BitmapAty;
import com.fuck.viewtest.menu.img.drawable.DrawableAty;
import com.fuck.viewtest.menu.img.fresco.FrescoAty;
import com.fuck.viewtest.menu.img.glide.GlideAty;

public class ImgAty extends AppCompatActivity {

    private Button btn_bitmap_factory;
    private Button btn_drawable;
    private Button btn_glide;
    private Button btn_fresco;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_bitmap_factory = findViewById(R.id.btn_bitmap_factory);
        btn_drawable = findViewById(R.id.btn_drawable);
        btn_glide = findViewById(R.id.btn_glide);
        btn_fresco = findViewById(R.id.btn_fresco);
    }

    private void initUI() {
        btn_bitmap_factory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toBitmapFactoryAty();
            }
        });
        btn_drawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toDrawableAty();
            }
        });
        btn_glide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toGlideAty();
            }
        });
        btn_fresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toFrescoAty();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    private void toBitmapFactoryAty() {
        Intent intent = new Intent(this, BitmapAty.class);
        startActivity(intent);
    }


    private void toDrawableAty() {
        Intent intent = new Intent(this, DrawableAty.class);
        startActivity(intent);
    }


    private void toGlideAty() {
        Intent intent = new Intent(this, GlideAty.class);
        startActivity(intent);
    }


    private void toFrescoAty() {
        Intent intent = new Intent(this, FrescoAty.class);
        startActivity(intent);
    }

}
