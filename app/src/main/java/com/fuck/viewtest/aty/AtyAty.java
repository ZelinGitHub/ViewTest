package com.fuck.viewtest.aty;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class AtyAty extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aty);
        Button button = new Button(this);
        button.setText("ABC");
        ViewGroup.LayoutParams layoutParams
                = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT
        );
        addContentView(button, layoutParams);
    }

}
