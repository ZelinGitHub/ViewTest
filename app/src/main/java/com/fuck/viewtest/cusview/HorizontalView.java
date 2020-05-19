package com.fuck.viewtest.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Scroller;

import com.fuck.viewtest.R;

/**
 * 仿横向LinearLayout
 */
public class HorizontalView extends ViewGroup {

    private int mLastInterceptX;

    private int mLastInterceptY;

    private int mLastX;

    private int mLastY;

    private int mCurrentIndex = 0;

    private int mChildWidth = 0;

    private Scroller mScroller;

    //速度追踪器
    private VelocityTracker mTracker;


    public HorizontalView(Context context) {
        this(context,null);
    }

    public HorizontalView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public HorizontalView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mScroller = new Scroller(getContext());
        //得到速度追踪器
        mTracker = VelocityTracker.obtain();
    }

    //onMeasure方法用来测量当前控件和开启测量子控件
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        //当控件的宽规格模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        //当控件的宽规格尺寸
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        //当控件的高规格模式
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        //当控件的高规格尺寸
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int defaultWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);

        int defaultHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        //开启测量子控件
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        View child0 = getChildAt(0);
        int childWidth = child0.getMeasuredWidth();
        int childHeight = child0.getMeasuredHeight();

        //如果没有子控件，设置当前控件测量尺寸为0
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        } else {
            //宽高都是AT_MOST，宽度设为所有子控件之宽之和，高设为一个子控件之高
            if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
                setMeasuredDimension(childWidth * getChildCount(), childHeight);
                //宽是AT_MOST，宽度设为所有子控件之宽之和
            } else if (widthMode == MeasureSpec.AT_MOST) {
                setMeasuredDimension(childWidth * getChildCount(), defaultHeight);
                //高是AT_MOST，高设为一个子控件之高
            } else if (heightMode == MeasureSpec.AT_MOST) {
                setMeasuredDimension(defaultWidth, childHeight);
                //其他情况使用View默认测量
            } else {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            }
        }
    }

    //onLayout方法用来开启布局子控件
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int left = 0;
        View child;
        for (int i = 0; i < childCount; i++) {
            //子控件
            child = getChildAt(i);
            //Gone的子控件不需要布局，不需要用来递增x坐标
            if (child.getVisibility() != View.GONE) {
                //子控件测量宽度
                mChildWidth = child.getMeasuredWidth();
                int childWidth = mChildWidth;
                //开启布局子控件
                child.layout(left, 0, left + childWidth, child.getMeasuredHeight());
                //左上角x坐标递增
                left += childWidth;
            }
        }
    }

    //onDraw方法用来绘制当前控件
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isIntercept = false;

        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                isIntercept = false;
                //如果惯性滑动没有完成
                if (!mScroller.isFinished()) {
                    //停止惯性滑动
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
//                int deltaX = x - mLastInterceptX;
//                int deltaY = y - mLastInterceptY;
//                //滑动方向是水平的，拦截事件
//                if (Math.abs(deltaX) - Math.abs(deltaY) > 0) {
//                    isIntercept = true;
//                } else {
//                    isIntercept = false;
//                }
                isIntercept = true;
                break;
            case MotionEvent.ACTION_UP:
                isIntercept = false;
                break;
        }
        mLastX = x;
        mLastY = y;
        mLastInterceptX = x;
        mLastInterceptY = y;
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //速度追踪器 添加事件
        mTracker.addMovement(event);
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                int deltaX = x - mLastX;
                //滑动
                scrollBy(-deltaX, 0);
                break;
            case MotionEvent.ACTION_UP:
                int distance = getScrollX() - mCurrentIndex * mChildWidth;
                //绝对值超过了子控件宽度一半
                if (Math.abs(distance) > mChildWidth / 2) {
                    //正向超过，进入下一个子控件
                    if (distance > 0) {
                        mCurrentIndex++;
                        //逆向超过，进入上一个子控件
                    } else {
                        mCurrentIndex--;
                    }
                    //绝对值没有超过子控件宽度一半
                } else {
                    //计算当前的速度
                    mTracker.computeCurrentVelocity(1000);
                    //x方向的速度
                    float xVelocity = mTracker.getXVelocity();
                    float yVelocity = mTracker.getYVelocity();
                    //如果速度绝对值超过50
                    if (Math.abs(xVelocity) > 50) {
                        //速度为正，进入下一个子控件
                        if (xVelocity > 0) {
                            mCurrentIndex++;
                            //速度为负，进入上一个子控件
                        } else {
                            mCurrentIndex--;
                        }
                    }
                }
                //如果小于0就是0，如果大于最末子控件角标就是最末子控件角标
                mCurrentIndex =
                        mCurrentIndex < 0 ?
                                0
                                : mCurrentIndex > getChildCount() - 1 ?
                                getChildCount() - 1
                                : mCurrentIndex;
                smoothScrollTo(mCurrentIndex * mChildWidth, 0);
                //清除速度追踪器
                mTracker.clear();
                break;
        }
        return super.onTouchEvent(event);
    }

    /**
     * 惯性滑动到目标位置
     * @param destX 目标位置横坐标
     * @param destY 目标位置纵坐标
     */
    private void smoothScrollTo(int destX, int destY) {
        //初始化滑动数据
        mScroller.startScroll(
                //起始位置x坐标
                getScrollX()
                //起始位置y坐标
                , getScrollY()
                //x方向滑动距离
                , destX - getScrollX()
                //y方向滑动距离
                , destY - getScrollY()
                , 1000
        );
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }

    public static class Star extends FrameLayout {
        public Star(Context context) {
            super(context);
            init(context);
        }

        public Star(Context context, AttributeSet attrs) {
            super(context, attrs);
            init(context);
        }

        public Star(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            init(context);
        }

        private void init(Context context) {
            LayoutInflater.from(context).inflate(R.layout.view_star,this,true);
            ImageView iv_star=findViewById(R.id.iv_star);
            iv_star.setImageResource(R.mipmap.star_red);
        }
    }
}
