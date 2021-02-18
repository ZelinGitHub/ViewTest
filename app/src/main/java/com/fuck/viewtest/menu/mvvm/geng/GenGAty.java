package com.fuck.viewtest.menu.mvvm.geng;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.fuck.viewtest.R;

public class GenGAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_name;
    private LinearLayout ll;
    private GenGViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_g);
        initView();
        initUI();
    }

    private void initView() {
        ll = findViewById(R.id.ll);
        btn_name = findViewById(R.id.btn_name);
    }

    private void initUI() {
        btn_name.setOnClickListener(this);
        initViewModel();
    }

    private void initViewModel() {
        mViewModel = new GenGViewModel();
        MyObserver myObserver = new MyObserver();
        mViewModel.mMediatorLiveData.observe(this, myObserver);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_name: {
                mViewModel.getData();
            }
        }
    }

    class MyObserver implements Observer<String> {
        @Override
        public void onChanged(String pS) {
            System.out.println(pS);
        }
    }

}
