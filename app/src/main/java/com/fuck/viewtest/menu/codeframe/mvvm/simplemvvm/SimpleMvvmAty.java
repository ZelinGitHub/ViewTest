package com.fuck.viewtest.menu.codeframe.mvvm.simplemvvm;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fuck.viewtest.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

public class SimpleMvvmAty extends AppCompatActivity {
    private TextView tv_name;
    private Button btn_name;
    private SimpleMvvmViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_mvvm);
        initViews();
        initUI();
    }

    private void initViews() {
        tv_name = findViewById(R.id.tv_name);
        btn_name = findViewById(R.id.btn_name);
    }

    private void initUI() {
        btn_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.getData();
            }
        });
        mViewModel = new SimpleMvvmViewModel();
        MyObserver myObserver = new MyObserver();
        mViewModel.mMutableLiveData.observe(this, myObserver);
    }


    class MyObserver implements Observer<String> {
        @Override
        public void onChanged(String pS) {
            tv_name.setText(pS);
        }
    }

}
