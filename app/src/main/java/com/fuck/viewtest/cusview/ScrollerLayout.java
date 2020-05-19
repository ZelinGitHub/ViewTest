package com.fuck.viewtest.cusview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

import androidx.core.view.ViewConfigurationCompat;

public class ScrollerLayout extends ViewGroup {

    private Scroller mScroller;

    private int mLeftBorder;

    private int mRightBorder;

    private float mDownX;

    private float mMoveX;

    private float mLastMoveX;


    private int mTouchSlop;

    public ScrollerLayout(Context context) {
        this(context,null);
    }

    public ScrollerLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ScrollerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mScroller = new Scroller(context);
        mTouchSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(context));
    }
    //onMeasure用来测量当前控件和开启测量子控件
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }
    }


    //onLayout用来开启布局子控件
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        if (changed) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = getChildAt(i);
                child.layout(
                        i * child.getMeasuredWidth()
                        , 0
                        , (i + 1) * child.getMeasuredWidth()
                        , child.getMeasuredHeight()
                );
            }
            mLeftBorder = getChildAt(0).getLeft();
            mRightBorder = getChildAt(getChildCount() - 1).getRight();
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                mDownX = ev.getX();
                break;
            }

            case MotionEvent.ACTION_MOVE: {
                mMoveX = ev.getX();
                float distance = Math.abs(mMoveX - mDownX);

                //大于这个距离表示滑动
                if (distance > mTouchSlop) {
                    mLastMoveX = mMoveX;
                    return true;
                }
                break;
            }

        }
        return super.onInterceptTouchEvent(ev);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE: {
                mMoveX = event.getX();
                int xScroll = (int) (mMoveX - mLastMoveX);
                //防止用户拖出边界，当拖出边界时就调用scrollTo()方法来回到边界位置
                if (getScrollX() - xScroll < mLeftBorder) {
                    scrollTo(mLeftBorder, 0);
                    return true;
                } else if (getScrollX() + getWidth()-xScroll>mRightBorder){
                    scrollTo(mRightBorder-getWidth(),0);
                    return true;
                }
                scrollBy(xScroll,0);
                mLastMoveX=mMoveX;
                break;
            }
            //手指抬起时，需要弹性滑动
            case MotionEvent.ACTION_UP:{
                //getScrollX是滚动条当前滑动到的坐标
                int targetIndex = (getScrollX() + getWidth() / 2) / getWidth();
                //应该弹性滑动的距离
                int xDistance = targetIndex * getWidth() - getScrollX();
                //初始化弹性滑动，从getScrollX(), 0位置开始，滑动xDistance, 0个距离
                mScroller.startScroll(getScrollX(), 0, xDistance, 0);
                //刷新界面
                invalidate();
                break;
            }
        }
        return super.onTouchEvent(event);

    }

    @Override
    public void computeScroll() {
        //计算惯性滑动的距离
        if(mScroller.computeScrollOffset()){
            //当前应该惯性滑动到的位置
            int currX=mScroller.getCurrX();
            int currY=mScroller.getCurrY();
            //滑动到指定位置
            scrollTo(currX,currY);
            //重绘界面
            invalidate();
        }
    }


}
