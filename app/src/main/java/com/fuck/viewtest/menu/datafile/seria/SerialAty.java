package com.fuck.viewtest.menu.datafile.seria;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class SerialAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_exe_serial;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_serial);
        initViews();
        initUI();
    }


    private void initViews() {
        btn_exe_serial = findViewById(R.id.btn_exe_serial);
    }

    private void initUI() {
        btn_exe_serial.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_exe_serial: {
                serial();
                break;
            }
        }
    }

    private void serial() {
        //创建一个对象
        Dog dog = new Dog();
        dog.age = 6;
        dog.name = "Spike";
        System.out.println("序列化的对象 " + dog.toString());
        //获得一个Parcel
        Parcel parcel = Parcel.obtain();
        //写出对象到Parcel
        dog.writeToParcel(parcel, 0);
        //从Parcel创建对象
        Dog dog_ = Dog.CREATOR.createFromParcel(parcel);
        System.out.println("反序列化的对象 " + dog_.toString());
        //回收Parcel
        parcel.recycle();
    }


}
