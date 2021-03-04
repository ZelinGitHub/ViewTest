package com.fuck.viewtest.menu.hook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class FuckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fuck);



    }

    public static Intent newIntent(Context pContext){
        return new Intent(pContext, FuckActivity.class);
    }
}
