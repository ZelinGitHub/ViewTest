package com.fuck.viewtest.menu.view_.webview;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class WebAty extends AppCompatActivity {

    private WebView wbv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initViews();
        initUI();
    }

    private void initViews() {
        wbv=findViewById(R.id.wbv);

    }

    private void initUI() {
        wbv.loadUrl("http://www.baidu.com");
    }




}
