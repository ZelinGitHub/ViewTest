package com.fuck.viewtest.menu.view_.cusview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.view_.cusview.event.MyViewAty;
import com.fuck.viewtest.menu.view_.cusview.myviewgroup.ChildMarginViewGroupAty;
import com.fuck.viewtest.menu.view_.cusview.myviewgroup.MyViewGroupAty;
import com.fuck.viewtest.menu.view_.cusview.myviewgroup.PaddingViewGroupAty;

public class CusvAty extends AppCompatActivity {

    private Button btn_my_viewgroup;
    private Button btn_child_margin_viewgroup;
    private Button btn_padding_viewgroup;
    private Button btn_my_view;

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
        btn_my_view = findViewById(R.id.btn_my_view);
    }

    private void initUI() {
        btn_my_viewgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toMyViewGroupAty();
            }
        });
        btn_child_margin_viewgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toChildMarginViewGroupAty();
            }
        });
        btn_padding_viewgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toPaddingViewGroupAty();
            }
        });

        btn_my_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toMyViewAty();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }


    private void toMyViewAty() {
        Intent intent = new Intent(this, MyViewAty.class);
        startActivity(intent);
    }

    private void toMyViewGroupAty() {
        Intent intent = new Intent(this, MyViewGroupAty.class);
        startActivity(intent);
    }

    private void toChildMarginViewGroupAty() {
        Intent intent = new Intent(this, ChildMarginViewGroupAty.class);
        startActivity(intent);
    }

    private void toPaddingViewGroupAty() {
        Intent intent = new Intent(this, PaddingViewGroupAty.class);
        startActivity(intent);
    }


}
