package com.fuck.viewtest.menu.anim.animator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class PointView extends View {
    public PointView(Context context) {
        this(context,null);
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
