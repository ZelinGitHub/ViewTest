package com.fuck.viewtest.cusview.myviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class PaddingViewGroup extends ViewGroup {
    public PaddingViewGroup(Context context) {
        this(context, null);
    }

    public PaddingViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaddingViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }


    public PaddingViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthDefaultSize = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        int heightDefaultSize = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);


        int measureWidth = 0;
        int measureHeight = 0;

        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();

        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            if (measureWidth == 0) {
                measureWidth = child.getMeasuredWidth();
            }
            measureHeight += child.getMeasuredHeight();
        }

        measureWidth += paddingLeft;
        measureWidth += paddingRight;

        measureHeight += paddingTop;
        measureHeight += paddingBottom;

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(measureWidth, measureHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(measureWidth, heightDefaultSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthDefaultSize, measureHeight);
        } else {
            setMeasuredDimension(widthDefaultSize, heightDefaultSize);
        }
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int paddingLeft = getPaddingLeft();
        int top = getPaddingTop();
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int right = paddingLeft+child.getMeasuredWidth();
            int bottom = top + child.getMeasuredHeight();
            child.layout(paddingLeft, top, right, bottom);
            top = bottom;
        }
    }
}
