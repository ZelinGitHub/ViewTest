package com.fuck.viewtest.menu.display.taskt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.fuck.viewtest.R;

public class SecondAty extends BaseAty {

    private Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondAty.this, ThirdAty.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected String initTag() {
        return "SecondAty";
    }


}
