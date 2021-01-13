package com.fuck.viewtest.menu.cusview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.fuck.viewtest.R;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MyFrameLayout extends FrameLayout {
    public MyFrameLayout(@NonNull Context context) {
        this(context, null);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public MyFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        addChildView4(context);
    }

    //调用ViewGroup的addView方法，为当前View添加一个子View
    private void addChildView(Context pContext) {
        TextView textView = new TextView(pContext);
        textView.setText("ABC");
        textView.setTextSize(100);
        textView.setTextColor(Color.BLUE);
        addView(textView, WRAP_CONTENT, WRAP_CONTENT);
    }

    private void addChildView2(Context pContext) {
        ImageView iv = new ImageView(pContext);
        iv.setImageResource(R.mipmap.lion_jack);
        iv.setScaleType(ImageView.ScaleType.CENTER);
        addView(iv, WRAP_CONTENT, WRAP_CONTENT);
    }

    //调用 LayoutInflater的inflate方法：
    //参数1传子控件的布局资源
    //参数2传this，使当前控件作为父控件
    //参数3传true，把子控件添加到当前控件
    //返回已经添加了子控件的当前控件，这个返回值没有用到
    private void addChildView3(Context pContext) {
        LayoutInflater.from(pContext).inflate(R.layout.view_lion, this, true);
    }

    private void addChildView4(Context pContext) {
        LayoutInflater.from(pContext).inflate(R.layout.view_lion, this, true);
        TextView tv_lion = findViewById(R.id.tv_lion);
        tv_lion.setText("狮子杰克");
        ImageView iv_lion = findViewById(R.id.iv_lion);
        iv_lion.setImageResource(R.mipmap.lion_jack);
    }

}
