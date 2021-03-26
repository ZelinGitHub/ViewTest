package com.fuck.viewtest.menu.view_.cusview.myviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.fuck.viewtest.R;

public class ChildMarginViewGroup extends ViewGroup {
    public ChildMarginViewGroup(Context context) {
        this(context, null);
    }

    public ChildMarginViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChildMarginViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ChildMarginViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void addChildViews(Context pContext) {
        View view1 = new View(pContext);
        View view2 = new View(pContext);
        view1.setBackgroundColor(getResources().getColor(R.color.redffff534BPrimary));
        view2.setBackgroundColor(getResources().getColor(R.color.orange_ringffff9434));

        MarginLayoutParams marginLayoutParams = new MarginLayoutParams(400, 200);
        marginLayoutParams.topMargin = 80;
        marginLayoutParams.leftMargin = 40;
        addView(view1, marginLayoutParams);
        addView(view2, marginLayoutParams);
    }

    private void addChildViews2(Context pContext) {
        View view1 = new View(pContext);
        View view2 = new View(pContext);
        view1.setBackgroundColor(getResources().getColor(R.color.redffff534BPrimary));
        view2.setBackgroundColor(getResources().getColor(R.color.orange_ringffff9434));
        addView(view1, 400, 200);
        addView(view2, 400, 200);
    }

    private void addChildViews3(Context pContext) {
        View view1 = new View(pContext);
        View view2 = new View(pContext);
        view1.setBackgroundColor(getResources().getColor(R.color.redffff534BPrimary));
        view2.setBackgroundColor(getResources().getColor(R.color.orange_ringffff9434));
        addView(view1);
        addView(view2);
    }

    private void addChildViews4(Context pContext) {
        View view1 = new View(pContext);
        View view2 = new View(pContext);
        view1.setBackgroundColor(getResources().getColor(R.color.redffff534BPrimary));
        view2.setBackgroundColor(getResources().getColor(R.color.orange_ringffff9434));

        LayoutParams layoutParams = new LayoutParams(400, 200);
        addView(view1, layoutParams);
        addView(view2, layoutParams);
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

    @Override
    protected boolean checkLayoutParams(LayoutParams p) {
        return p instanceof MarginLayoutParams;
    }


    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }


    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    }

}
