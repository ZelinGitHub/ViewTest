package com.fuck.viewtest.menu.view_;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.menu.datafile.res.ResAty;
import com.fuck.viewtest.menu.display.aty.AtyAty;
import com.fuck.viewtest.menu.view_.cusview.CusvAty;
import com.fuck.viewtest.menu.view_.framelayout.FrameLayoutAty;
import com.fuck.viewtest.menu.view_.rv.RvAty;
import com.fuck.viewtest.menu.view_.scroll.ScrollAty;
import com.fuck.viewtest.menu.view_.scrollview.ScrollViewAty;
import com.fuck.viewtest.menu.view_.surfaceview.SurfaceViewAty;
import com.fuck.viewtest.menu.view_.textview.TextAty;
import com.fuck.viewtest.menu.view_.viewviewgroup.VAty;
import com.fuck.viewtest.menu.view_.vp.VpAty;

//ABC
public class ViewAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_vp;
    private Button btn_cusv;
    private Button btn_rv;
    private Button btn_sv;
    private Button btn_v;
    private Button btn_scroll;
    private Button btn_surfaceview;
    private Button btn_webview;
    private Button btn_textview;
    private Button btn_framelayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        initViews();
        initUI();
    }


    private void initViews() {
        btn_vp = findViewById(R.id.btn_vp);
        btn_cusv = findViewById(R.id.btn_cusv);
        btn_rv = findViewById(R.id.btn_rv);
        btn_sv = findViewById(R.id.btn_sv);
        btn_v = findViewById(R.id.btn_v);
        btn_scroll = findViewById(R.id.btn_scroll);
        btn_surfaceview = findViewById(R.id.btn_surfaceview);
        btn_webview = findViewById(R.id.btn_webview);
        btn_textview = findViewById(R.id.btn_textview);
        btn_framelayout = findViewById(R.id.btn_framelayout);
    }


    private void initUI() {
        btn_cusv.setOnClickListener(this);
        btn_vp.setOnClickListener(this);
        btn_rv.setOnClickListener(this);
        btn_sv.setOnClickListener(this);
        btn_v.setOnClickListener(this);
        btn_scroll.setOnClickListener(this);
        btn_surfaceview.setOnClickListener(this);
        btn_webview.setOnClickListener(this);
        btn_textview.setOnClickListener(this);
        btn_framelayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_vp: {
                Intent intent = new Intent(this, VpAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_cusv: {
                Intent intent = new Intent(this, CusvAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_rv: {
                Intent intent = new Intent(this, RvAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_sv: {
                Intent intent = new Intent(this, ScrollViewAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_v: {
                Intent intent = new Intent(this, VAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_scroll: {
                Intent intent = new Intent(this, ScrollAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_aty: {
                Intent intent = new Intent(this, AtyAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_surfaceview: {
                Intent intent = new Intent(this, SurfaceViewAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_webview: {
                Intent intent = new Intent(this, ResAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_textview: {
                Intent intent = new Intent(this, TextAty.class);
                startActivity(intent);
                break;
            }
            case R.id.btn_framelayout: {
                Intent intent = new Intent(this, FrameLayoutAty.class);
                startActivity(intent);
                break;
            }
        }
    }
}
