package com.fuck.viewtest.menu.rv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.rv.swiperv.SwipeRvAty;

public class RvAty extends AppCompatActivity implements View.OnClickListener {

    private Button open_swipe_rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvi);
        initViews();
        initUI();
    }

    private void initViews() {
        open_swipe_rv=findViewById(R.id.btn_swipe_rv);
    }

    private void initUI() {
        open_swipe_rv.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_swipe_rv:{
                Intent intent = new Intent(this, SwipeRvAty.class);
                startActivity(intent);
                break;
            }
        }
    }
}
