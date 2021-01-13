package com.fuck.viewtest.menu.aidl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class PoolClientAty extends AppCompatActivity implements View.OnClickListener {

    private Button btn_bind_pool_server;
    private Button btn_encrypt;
    private Button btn_decipher;
    private Button btn_plus;
    private Button btn_unbind_pool_server;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_client);
        initViews();
        initUI();
    }

    private void initViews() {

        btn_bind_pool_server = findViewById(R.id.btn_bind_pool_server);
        btn_encrypt = findViewById(R.id.btn_encrypt);
        btn_decipher = findViewById(R.id.btn_decipher);
        btn_plus = findViewById(R.id.btn_plus);
        btn_unbind_pool_server = findViewById(R.id.btn_unbind_pool_server);
    }

    private void initUI() {

        btn_bind_pool_server.setOnClickListener(this);
        btn_encrypt.setOnClickListener(this);
        btn_decipher.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_unbind_pool_server.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bind_pool_server: {
                bindPoolServer();
                break;
            }
            case R.id.btn_encrypt: {
                encrypt();
                break;
            }
            case R.id.btn_decipher: {
                decipher();
                break;
            }
            case R.id.btn_plus: {
                plus();
                break;
            }
            case R.id.btn_unbind_pool_server: {
                unbindPoolServer();
                break;
            }
        }
    }

    private void bindPoolServer() {

    }

    private void encrypt() {

    }

    private void decipher() {

    }

    private void plus() {

    }

    private void unbindPoolServer() {

    }

    class PoolServiceConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}