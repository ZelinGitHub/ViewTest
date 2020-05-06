package com.fuck.viewtest.conprovider;

import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.fuck.viewtest.broadcast.MyBroadcastReceiver;

public class BroadcastTestAty extends AppCompatActivity implements View.OnClickListener {

    private BroadcastReceiver mBroadcastReceiver=new MyBroadcastReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_test);


    }






    @Override
    public void onClick(View v) {
    }
}
