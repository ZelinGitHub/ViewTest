package com.fuck.viewtest.menu.window;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;

import com.fuck.viewtest.R;

import androidx.appcompat.app.AppCompatActivity;

public class AddWindowAty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);
        initViews();
        initUI();
    }


    private void initViews() {

    }

    private void initUI() {
        addWindowDefault(this);
        addWindowCenter(this);
        addWindowLeftTop(this);
        addWindowRightBottom(this);
    }

    private void addWindowDefault(Activity pActivity) {
        View view = new View(pActivity);
        view.setBackgroundColor(getResources().getColor(R.color.purple_ff9932CD));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSPARENT;
        layoutParams.width = 200;
        layoutParams.height = 400;
        pActivity.getWindowManager().addView(view, layoutParams);
    }

    private void addWindowCenter(Activity pActivity) {
        View view = new View(pActivity);
        view.setBackgroundColor(getResources().getColor(R.color.green_ringff95e11c));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSPARENT;
        layoutParams.width = 200;
        layoutParams.height = 400;
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.x = 100;
        layoutParams.y = 200;
        pActivity.getWindowManager().addView(view, layoutParams);
    }

    private void addWindowLeftTop(Activity pActivity) {
        View view = new View(pActivity);
        view.setBackgroundColor(getResources().getColor(R.color.blueff0d79cdPrimary));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSPARENT;
        layoutParams.width = 200;
        layoutParams.height = 400;
        layoutParams.gravity = Gravity.START | Gravity.TOP;
        layoutParams.x = 100;
        layoutParams.y = 200;
        pActivity.getWindowManager().addView(view, layoutParams);
    }

    private void addWindowRightBottom(Activity pActivity) {
        View view = new View(pActivity);
        view.setBackgroundColor(getResources().getColor(R.color.redffff534BPrimary));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSPARENT;
        layoutParams.width = 200;
        layoutParams.height = 400;
        layoutParams.gravity = Gravity.END | Gravity.BOTTOM;
        layoutParams.x = 100;
        layoutParams.y = 200;
        pActivity.getWindowManager().addView(view, layoutParams);
    }


    private void fuckWindowGravity() {
        int a = Gravity.LEFT;
        int a2 = Gravity.START;
        int b = Gravity.RIGHT;
        int b2 = Gravity.END;
        int c = Gravity.TOP;
        int d = Gravity.BOTTOM;
        int e = Gravity.CENTER;
        int e2 = Gravity.CENTER_HORIZONTAL;
        int e3 = Gravity.CENTER_VERTICAL;
        int f = Gravity.FILL;
        int f2 = Gravity.FILL_HORIZONTAL;
        int f3 = Gravity.FILL_VERTICAL;
    }


}
