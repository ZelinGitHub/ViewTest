package com.fuck.viewtest.mvvm.rng;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.fuck.viewtest.R;

public class RngAty extends AppCompatActivity {
    private TextView tv_count;
    private TextView tv_count2;
    private EditText et;
    private RngViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rng);
        initView();
        initUI();

    }

    private void initView() {
        tv_count = findViewById(R.id.tv_count);
        tv_count2 = findViewById(R.id.tv_count2);
        et = findViewById(R.id.et);
    }

    private void initUI() {
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
        mViewModel = new RngViewModel();

        mViewModel.mMediatorLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer pInteger) {
                tv_count.setText(String.valueOf(pInteger));
            }
        });

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
                tv_count2.setText(String.valueOf(pInteger));
            }
        });
    }


}
