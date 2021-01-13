package com.fuck.viewtest.menu.cusview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class CusvAty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_my_viewgroup;
    private Button btn_child_margin_viewgroup;
    private Button btn_padding_viewgroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cusv);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_my_viewgroup = findViewById(R.id.btn_my_viewgroup);
        btn_child_margin_viewgroup = findViewById(R.id.btn_child_margin_viewgroup);
        btn_padding_viewgroup = findViewById(R.id.btn_padding_viewgroup);
    }

    private void initUI() {
        btn_my_viewgroup.setOnClickListener(this);
        btn_child_margin_viewgroup.setOnClickListener(this);
        btn_padding_viewgroup.setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.btn_my_viewgroup: {
                Intent intent = new Intent(this, MyViewGroupAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_child_margin_viewgroup: {
                Intent intent = new Intent(this, ChildMarginViewGroupAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_padding_viewgroup: {
                Intent intent = new Intent(this, PaddingViewGroupAty.class);
                startActivity(intent);
                break;
            }
        }
    }
}
