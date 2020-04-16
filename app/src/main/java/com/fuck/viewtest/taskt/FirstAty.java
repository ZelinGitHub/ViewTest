package com.fuck.viewtest.taskt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fuck.viewtest.R;

public class FirstAty extends BaseAty {

    private Button btn;
    private Button btn2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstAty.this, SecondAty.class);
                startActivityForResult(intent,0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstAty.this, FourAty.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected String initTag() {
        return "FirstAty";
    }


}
