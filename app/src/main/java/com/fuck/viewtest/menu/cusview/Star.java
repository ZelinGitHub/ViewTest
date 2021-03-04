package com.fuck.viewtest.menu.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.fuck.viewtest.R;

public class Star extends FrameLayout {
    public Star(Context context) {
        this(context, null);
    }

    public Star(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Star(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_star, this, true);
        ImageView iv_star = findViewById(R.id.iv_star);
        iv_star.setImageResource(R.mipmap.star_black);
    }

}

