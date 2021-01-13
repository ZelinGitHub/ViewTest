package com.fuck.viewtest.menu.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class SidePullRecyclerView extends RecyclerView {
    public SidePullRecyclerView(@NonNull Context context) {
        this(context,null);
    }

    public SidePullRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SidePullRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {
        return super.onInterceptTouchEvent(e);
    }
}
