package com.fuck.viewtest.menu.display.taskt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.fuck.viewtest.R;

public class FirstAty extends BaseAty {

    private Button btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(FirstAty.this, SecondAty.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected String initTag() {
        return "FirstAty";
    }


}
