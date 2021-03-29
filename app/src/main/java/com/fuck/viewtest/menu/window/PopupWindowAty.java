package com.fuck.viewtest.menu.window;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class PopupWindowAty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindow);
        initViews();
        initUI();
    }


    private void initViews() {

    }

    private void initUI() {


    }


    private void addPopupWindow() {

        PopupWindow popupWindow = new PopupWindow();
    }

    private void addPopupWindow2(Context pContext) {

        View view = new View(pContext);
        view.setBackgroundColor(getResources().getColor(R.color.blueff0d79cdPrimary));

        //传入
        PopupWindow popupWindow = new PopupWindow(
                //Window的View，PopupWindow没有默认的View
                view
                //Window宽度
                , 400
                //Window高度
                , 800
                //是否可以获得焦点，不传默认为false
                , true
        );
    }
}
