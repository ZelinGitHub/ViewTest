package com.fuck.viewtest.win;

import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class WinAty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);


        addWindowView();

        addPopupWindow();
    }


    private void addWindowView() {
        View view = new View(this);
        view.setBackgroundColor(getResources().getColor(R.color.blueff0d79cdPrimary));
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.format = PixelFormat.TRANSPARENT;
        layoutParams.width = 400;
        layoutParams.height = 800;
        layoutParams.x = 0;
        layoutParams.y = 0;
        layoutParams.gravity = Gravity.START | Gravity.TOP;
        getWindowManager().addView(view, layoutParams);
    }

    private void addPopupWindow() {
        PopupWindow popupWindow = new PopupWindow();
    }
}
