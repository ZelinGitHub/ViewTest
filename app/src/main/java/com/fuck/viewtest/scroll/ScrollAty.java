package com.fuck.viewtest.scroll;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class ScrollAty extends AppCompatActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        initViews();
        initUI();
    }


    private void initViews() {
        v = findViewById(R.id.v);
    }

    private void initUI() {
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        System.out.println(event.getX() + "//" + event.getY());
                    }
                }
                return true;
            }
        });
    }

}
