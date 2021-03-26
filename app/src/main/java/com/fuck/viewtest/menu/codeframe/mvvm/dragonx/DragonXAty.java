package com.fuck.viewtest.menu.codeframe.mvvm.dragonx;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.fuck.viewtest.R;

public class DragonXAty extends AppCompatActivity implements View.OnClickListener {
    private TextView tv_name;
    private Button btn_name;
    private DragonXViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dragon_x);
        initView();
        initUI();
    }

    private void initView() {
        tv_name = findViewById(R.id.tv_name);
        btn_name = findViewById(R.id.btn_name);
    }

    private void initUI() {
        btn_name.setOnClickListener(this);
        mViewModel = new DragonXViewModel();
        MyObserver myObserver = new MyObserver();
        mViewModel.mMutableLiveData.observe(this, myObserver);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_name:{
                mViewModel.getData();
            }
        }
    }

    class MyObserver implements Observer<String> {
        @Override
        public void onChanged(String pS) {
            tv_name.setText(pS);
        }
    }

}
