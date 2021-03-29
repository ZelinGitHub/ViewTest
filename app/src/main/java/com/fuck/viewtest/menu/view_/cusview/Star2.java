package com.fuck.viewtest.menu.view_.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.fuck.viewtest.R;

public class Star2 extends FrameLayout {
    public Star2(Context context) {
        this(context, null);
    }

    public Star2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Star2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        ImageView iv=new ImageView(context);
        iv.setImageResource(R.mipmap.star_red);
        addView(iv,20,20);
    }

}

