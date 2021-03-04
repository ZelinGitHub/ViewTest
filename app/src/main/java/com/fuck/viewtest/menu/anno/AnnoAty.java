package com.fuck.viewtest.menu.anno;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class AnnoAty extends AppCompatActivity {

    private Button btn_first;
    private Button btn_second;
    private Button btn_third;
    private Button btn_forth;
    private Button btn_fifth;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anno);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_first = findViewById(R.id.btn_first);
        btn_second = findViewById(R.id.btn_second);
        btn_third = findViewById(R.id.btn_third);
        btn_forth = findViewById(R.id.btn_forth);
        btn_fifth = findViewById(R.id.btn_fifth);
    }

    private void initUI() {
        ActionListenerInstaller2.processAnnotations(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @ActionListenerFor(source = "btn_first")
    public void onClickFirst() {
        System.out.println("我是第一个按钮");
    }

    @ActionListenerFor(source = "btn_second")
    public void onClickSecond() {
        System.out.println("我是第二个按钮");

    }

    @ActionListenerFor(source = "btn_third")
    public void onClickThird() {
        System.out.println("我是第三个按钮");

    }

    @ActionListenerFor(source = "btn_forth")
    public void onClickForth() {
        System.out.println("我是第四个按钮");

    }

    @ActionListenerFor(source = "btn_fifth")
    public void onClickFifth() {
        System.out.println("我是第五个按钮");

    }
}
