package com.fuck.viewtest.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImgAty extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        initViews();
        initUI();
    }

    private void initViews() {
    }

    private void initUI() {

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    @Override
    public void onClick(View v) {

    }


    private void loadFromResources() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.united_kingdom);

    }

    private void loadFromBytes(){
        byte[] myBytes=new byte[]{0,1,0,1};
        Bitmap bm = BitmapFactory.decodeByteArray(myBytes,0,myBytes.length);
    }
    private void loadFromFile() {

        String path="/sdcard/Download/sample.png";
        Bitmap bitmap= BitmapFactory.decodeFile(path);
    }

    private void loadFromStream() {
        try {
            FileInputStream in = new FileInputStream("/sdcard/Download/sample.png");
            Bitmap bitmap= BitmapFactory.decodeStream(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
