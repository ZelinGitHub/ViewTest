package com.fuck.viewtest.menu.view_.cusview.myviewgroup;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.fuck.viewtest.R;

public class MyViewGroup extends ViewGroup {
    public MyViewGroup(Context context) {
        this(context, null);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    //在构造方法中添加子控件
    public MyViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        View view1 = new View(context);
        View view2 = new View(context);
        View view3 = new View(context);
//        View view4 = new View(context);
//        View view5 = new View(context);
//        View view6 = new View(context);
//        View view7 = new View(context);
        view1.setBackgroundColor(getResources().getColor(R.color.redffff534BPrimary));
        view2.setBackgroundColor(getResources().getColor(R.color.orange_ringffff9434));
        view3.setBackgroundColor(getResources().getColor(R.color.yellowffffff00));
//        view4.setBackgroundColor(getResources().getColor(R.color.green_ringff95e11c));
//        view5.setBackgroundColor(getResources().getColor(R.color.blue_ringff0bd9f1));
//        view6.setBackgroundColor(getResources().getColor(R.color.blueff0d79cdPrimary));
//        view7.setBackgroundColor(getResources().getColor(R.color.purple_ff9932CD));
        addView(view1, 400, 200);
        addView(view2, 400, 200);
        addView(view3, 400, 200);
//        addView(view4, 400, 200);
//        addView(view5, 400, 200);
//        addView(view6, 400, 200);
//        addView(view7, 400, 200);
    }

    private void addView(View pView6, int pI, int pI1, int pI2) {
    }

    //重写onMeasure方法
    //测量子控件
    //当前控件测量宽度等于子控件测量宽度
    //当前控件测量高度等于所有子控件测量高度之和
    //测量完所有子控件之后，设置当前控件的测量宽度和测量高度
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
            if (measureWidth == 0) {
                measureWidth = child.getMeasuredWidth();
            }
            measureHeight += child.getMeasuredHeight();
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
    //所有子控件的左上角横坐标都是0
    //所有子控件的右下角横坐标都是子控件的测量宽度值
    //子控件的左上角纵坐标和右下角纵坐标依次累加子控件的测量高度值
    //布局子控件
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int top = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            int right = child.getMeasuredWidth();
            int bottom = top + child.getMeasuredHeight();
            child.layout(0, top, right, bottom);
            top = bottom;
        }
    }
}
