package com.fuck.viewtest.img;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ImgAty extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        initViews();
        initUI();
    }

    private void initViews() {
        iv = findViewById(R.id.iv);
    }

    private void initUI() {
        loadFromResources();
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

    private void decodeSample() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.united_kingdom, options);
        int width = options.outWidth;
        int height = options.outHeight;

        int halfWidth = width / 2;
        int halfHeight = height / 2;
        int inSampleSize = 1;

        options.inSampleSize = 2;
        options.inJustDecodeBounds = false;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.united_kingdom, options);

    }

    private void loadFromResources() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.united_kingdom);
        iv.setImageBitmap(bitmap);
    }

    private void loadFromBytes() {
        byte[] myBytes = new byte[]{0, 1, 0, 1};
        Bitmap bm = BitmapFactory.decodeByteArray(myBytes, 0, myBytes.length);
    }

    private void loadFromFile() {

        String path = "/sdcard/Download/sample.png";
        Bitmap bitmap = BitmapFactory.decodeFile(path);
    }

    private void loadFromStream() {
        try {
            FileInputStream in = new FileInputStream("/sdcard/Download/sample.png");
            Bitmap bitmap = BitmapFactory.decodeStream(in);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int calculateInSampleSize(
            BitmapFactory.Options pOptions
            , int reqWidth
            , int reqHeight
    ) {
        int height = pOptions.outHeight;
        int width = pOptions.outWidth;
        int inSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            int halfHeight = height / 2;
            int halfWidth = width / 2;
            while ((halfHeight / inSampleSize) >= reqHeight && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }
        return inSampleSize;
    }
}
