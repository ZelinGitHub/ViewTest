package com.fuck.viewtest.menu.view_.textview;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

public class TextAty extends AppCompatActivity {

    private TextView tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        initViews();
        initUI();
    }

    private void initViews() {
        tv = findViewById(R.id.tv);

    }

    private void initUI() {
        setImageSpan();

        AbsoluteSizeSpan absoluteSizeSpan;
    }

    private void setImageSpan() {
        CenterImageSpan imageSpan = new CenterImageSpan(this, R.mipmap.lion);
        String str = "  123";
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(imageSpan, 0, 1, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE);
        tv.setText(spannableString);
    }


}
