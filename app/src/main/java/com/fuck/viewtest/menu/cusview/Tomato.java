package com.fuck.viewtest.menu.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class Tomato extends ViewGroup {
    public Tomato(Context context) {
        this(context,null);
    }

    public Tomato(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public Tomato(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr,0);
    }

    public Tomato(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    //返回MarginLayoutParams来支持子控件margin布局参数
    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    //返回MarginLayoutParams来支持子控件margin布局参数
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    //返回MarginLayoutParams来支持子控件margin布局参数
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);

        int measureWidth = 0;
        int measureHeight = 0;
        for (int i = 0; i < getChildCount(); i++) {
            //得到子控件
            View child = getChildAt(i);
            //开启测量子控件
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            //得到子控件布局参数
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            measureHeight += child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            measureWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
        }

        if (widthSpecMode == MeasureSpec.AT_MOST && heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(measureWidth, measureHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(measureWidth, getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec), measureHeight);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    //用来布局子控件
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 0;
        for (int i = 0; i < getChildCount(); i++) {
            //得到子控件
            View child = getChildAt(i);
            //得到子控件布局参数
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();

            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            //开启布局子控件
            child.layout(
                    0
                    , top
                    , childWidth
                    , top + childHeight
            );
            top += childHeight;
        }
    }
}
