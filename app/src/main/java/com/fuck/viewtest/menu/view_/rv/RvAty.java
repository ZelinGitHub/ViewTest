package com.fuck.viewtest.menu.view_.rv;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.view_.rv.ui.RvDividerAty;
import com.fuck.viewtest.menu.view_.rv.ui.RvDragExchangeAty;
import com.fuck.viewtest.menu.view_.rv.ui.RvFlagAty;
import com.fuck.viewtest.menu.view_.rv.ui.RvGridAty;
import com.fuck.viewtest.menu.view_.rv.ui.RvHorizontalListAty;
import com.fuck.viewtest.menu.view_.rv.ui.RvSlideDeleteAty;
import com.fuck.viewtest.menu.view_.rv.ui.RvStaggerAty;
import com.fuck.viewtest.menu.view_.rv.ui.RvSwipeAty;
import com.fuck.viewtest.menu.view_.rv.ui.RvTimeAxisAty;

public class RvAty extends AppCompatActivity {

    private Button btn_swipe_rv;
    private Button btn_stagger;
    private Button btn_list;
    private Button btn_grid;
    private Button btn_divider;
    private Button btn_flag;
    private Button btn_time_axis;
    private Button btn_slide_delete;
    private Button btn_drag_exchange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_swipe_rv = findViewById(R.id.btn_swipe_rv);
        btn_stagger = findViewById(R.id.btn_stagger);
        btn_list = findViewById(R.id.btn_horizontal_list);
        btn_grid = findViewById(R.id.btn_grid);
        btn_divider = findViewById(R.id.btn_divider);
        btn_flag = findViewById(R.id.btn_flag);
        btn_time_axis = findViewById(R.id.btn_time_axis);
        btn_slide_delete = findViewById(R.id.btn_slide_delete);
        btn_drag_exchange = findViewById(R.id.btn_drag_exchange);
    }

    private void initUI() {
        btn_swipe_rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RvSwipeAty.class);
                startActivity(intent);
            }
        });
        btn_stagger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RvStaggerAty.class);
                startActivity(intent);
            }
        });
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RvHorizontalListAty.class);
                startActivity(intent);
            }
        });
        btn_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RvGridAty.class);
                startActivity(intent);
            }
        });
        btn_divider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RvDividerAty.class);
                startActivity(intent);
            }
        });
        btn_flag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RvFlagAty.class);
                startActivity(intent);
            }
        });
        btn_time_axis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RvTimeAxisAty.class);
                startActivity(intent);
            }
        });

        btn_slide_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RvSlideDeleteAty.class);
                startActivity(intent);
            }
        });
        btn_drag_exchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RvDragExchangeAty.class);
                startActivity(intent);
            }
        });
    }

    private Context getContext() {
        return this;
    }


}
