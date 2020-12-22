package com.fuck.viewtest.cusview;


import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.fuck.viewtest.R;

public class Glue extends View {
    public Glue(Context context) {
        this(context, null);
    }

    public Glue(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Glue(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public Glue(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Glue, defStyleAttr, 0);
        int width = a.getLayoutDimension(R.styleable.Glue_android_layout_width, -1);
        int height = a.getLayoutDimension(R.styleable.Glue_android_layout_height, -2);
        System.out.println("控件配置的宽度是"+width);
        System.out.println("控件配置的高度是"+height);
        a.recycle();
    }
}
