package com.fuck.viewtest.menu.mvvm.rng2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.fuck.viewtest.R;

public class Rng2Aty extends AppCompatActivity {
    private TextView tv_count;
    private EditText et;
    private Rng2ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rng2);
        initView();
        initUI();
    }

    private void initView() {
        tv_count = findViewById(R.id.tv_count);
        et = findViewById(R.id.et);
    }

    private void initUI() {
        //为EditText添加监听
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence pCharSequence, int pI, int pI1, int pI2) {
            }

            @Override
            public void onTextChanged(CharSequence pCharSequence, int pI, int pI1, int pI2) {
            }
            @Override
            public void afterTextChanged(Editable pEditable) {
                mViewModel.postValue(pEditable.toString());
            }
        });
        mViewModel = new Rng2ViewModel();
        mViewModel.mMutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String pS) {
                if (pS != null) {
                    int count = pS.length();
                    mViewModel.mMutableLiveData2.setValue(count);
                }
            }
        });
        mViewModel.mMutableLiveData2.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer pInteger) {
                tv_count.setText(String.valueOf(pInteger));
            }
        });
    }


}
