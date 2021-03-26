package com.fuck.viewtest.menu.codeframe.mvvm.geng2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.fuck.viewtest.R;

public class GenG2Aty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_name;
    private GenG2ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_g2);
        initView();
        initUI();
    }

    private void initView() {
        btn_name = findViewById(R.id.btn_name);
    }

    private void initUI() {
        btn_name.setOnClickListener(this);
        initViewModel();
    }

    private void initViewModel() {
        mViewModel = new GenG2ViewModel();
        mViewModel.mMutableLiveData4.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String pS) {
                System.out.println(pS);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_name: {
                mViewModel.getData();
            }
        }
    }
}
