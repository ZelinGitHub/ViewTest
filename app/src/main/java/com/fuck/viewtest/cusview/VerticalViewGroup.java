package com.fuck.viewtest.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class VerticalViewGroup extends ViewGroup {
    public VerticalViewGroup(Context context) {
        this(context, null);
    }

    public VerticalViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VerticalViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public VerticalViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    //重写onMeasure方法
    //测量子控件
    //设置当前控件的测量尺寸，考虑子控件的外边距
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthDefaultSize = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);
        int heightDefaultSize = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);


        int measureWidth = 0;
        int measureHeight = 0;
        //子控件的测量宽度、测量高度和外边距是分开的
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            if (measureWidth == 0) {
                measureWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            }
            measureHeight += child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
        }

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

    //重写onLayout方法
    //布局子控件，考虑子控件的外边距
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int left = lp.leftMargin;
            if (top == 0) {
                top = lp.topMargin;
            }
            int right = child.getMeasuredWidth();
            int bottom = top + child.getMeasuredHeight();
            child.layout(left, top, right, bottom);
            top = bottom + lp.bottomMargin + lp.topMargin;
        }
    }

    //重写generateLayoutParams(LayoutParams p)
    //创建MarginLayoutParams
    //
    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    //重写generateLayoutParams(AttributeSet attrs)
    //创建MarginLayoutParams
    //LayoutInflater在创建控件时，会调用这个方法，为子控件生成布局参数
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    //重写generateDefaultLayoutParams
    //创建MarginLayoutParams
    //在添加子控件时，如果子控件没有设置布局参数，会调用这个方法，为子控件生成默认的布局参数
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

}
