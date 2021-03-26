package com.fuck.viewtest.menu.datafile.res;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

import java.io.IOException;
import java.io.InputStream;

public class ResAty extends AppCompatActivity {

    private Button btn_raw;
    private Button btn_raw2;
    private Button btn_assets;
    private ImageView iv1;
    private ImageView iv2;
    private ImageView iv1_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_raw = findViewById(R.id.btn_raw);
        btn_raw2 = findViewById(R.id.btn_raw2);
        btn_assets = findViewById(R.id.btn_assets);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv1_ = findViewById(R.id.iv1_);
    }

    private void initUI() {
        btn_raw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readRaw1(ResAty.this);
            }
        });
        btn_raw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readRaw2(ResAty.this);
            }
        });

        btn_assets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readAssets(ResAty.this);
            }
        });
    }

    private void readRaw1(Context pContext) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = pContext.getResources().openRawResource(R.raw.roc);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                iv1.setImageBitmap(bitmap);
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (IOException pE) {
            pE.printStackTrace();
        }

    }

    private void readRaw2(Context pContext) {
        String packageName = pContext.getPackageName();
        Uri uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.kmt);

        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(pContext.getContentResolver(), uri);
            iv1_.setImageBitmap(bitmap);

        } catch (IOException pE) {
            pE.printStackTrace();
        }

    }


    private void readAssets(Context pContext) {
        AssetManager assetManager = pContext.getAssets();
        InputStream inputStream = null;
        try {
            try {
                inputStream = assetManager.open("america.jpg");
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                iv2.setImageBitmap(bitmap);
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (IOException pE) {
            pE.printStackTrace();
        }
    }


}
