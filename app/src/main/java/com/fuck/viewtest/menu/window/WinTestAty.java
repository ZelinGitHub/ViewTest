package com.fuck.viewtest.menu.window;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fuck.viewtest.R;

import androidx.appcompat.app.AppCompatActivity;

public class WinTestAty extends AppCompatActivity{

    private Button btn_window;
    private Button btn_popupwindow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_window = findViewById(R.id.btn_window);
        btn_popupwindow = findViewById(R.id.btn_popupwindow);
    }

    private void initUI() {
        btn_window.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toAddWindowAty();
            }
        });
        btn_popupwindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toPopupWindowAty();
            }
        });
    }

    private void toAddWindowAty() {
        Intent intent = new Intent(this, AddWindowAty.class);
        startActivity(intent);
    }
    private void toPopupWindowAty() {
        Intent intent = new Intent(this, PopupWindowAty.class);
        startActivity(intent);
    }

}
