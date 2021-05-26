package com.fuck.viewtest.menu.view_.cusview.event;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import java.io.IOException;
import java.io.InputStream;

public class LargeImg extends View {
    //图片加载区域
    private  Rect mRect;
    //用来内存复用
    private  BitmapFactory.Options mOptions;
    private GestureDetector mGestureDetector;
    private Scroller mScroller;
    private int mImgWidth;
    private int mImgHeight;
    private BitmapRegionDecoder mBitmapRegionDecoder;

    private int mViewWidth;
    private int mViewHeight;

    private float mScale;

    private Bitmap mBitmap;

    private Matrix mMatrix=new Matrix();

    public LargeImg(Context context) {
        this(context,null);
    }

    public LargeImg(Context context, AttributeSet attrs) {
        this(context, attrs,0);

    }

    public LargeImg(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mViewWidth=getMeasuredWidth();
        mViewHeight=getMeasuredHeight();

        mRect.left=0;
        mRect.top=0;
        mRect.right=mImgWidth;

        mScale=mViewWidth/(float)mImgWidth;
        mRect.bottom=(int)(mViewHeight/mScale);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(mBitmapRegionDecoder==null){
            return;
        }
        //内存复用，复用的bitmap必须和即将解码的bitmap尺寸一样
        mOptions.inBitmap=mBitmap;
        //指定解码区域
        mBitmap=mBitmapRegionDecoder.decodeRegion(mRect,mOptions);

        //得到矩阵进行缩放
        mMatrix.setScale(mScale,mScale);

        canvas.drawBitmap(mBitmap,mMatrix,null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mGestureDetector.onTouchEvent(event);
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(mScroller.isFinished()){
            return;
        }
        if(mScroller.computeScrollOffset()){
            mRect.top=mScroller.getCurrY();
            mRect.bottom=mRect.top+(int)(mViewHeight/mScale);
            invalidate();
        }
    }

    private void init(Context pContext){
        mRect=new Rect();
        mOptions=new BitmapFactory.Options();
        mScroller=new Scroller(pContext);
        mGestureDetector=new GestureDetector(pContext, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                if(!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                //上下移动，改变显示区域
                mRect.offset(0,(int)distanceX);

                if(mRect.bottom>mImgHeight){
                    mRect.bottom=mImgHeight;
                    mRect.top=mImgHeight-(int)(mViewHeight/mScale);
                }

                if(mRect.top<0){
                    mRect.top=0;
                    mRect.bottom=(int)(mViewHeight/mScale);
                }
                invalidate();
                return true;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            //惯性滑动
            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                mScroller.fling(
                        0
                        ,mRect.top
                        ,(int)velocityX
                        ,(int)-velocityY
                        ,0
                        ,0
                        ,0
                        ,mImgHeight-(int)(mViewHeight/mScale)
                        );
                return true;
            }
        });
    }

    /**
     * 设置图片，得到图片的信息
     * @param pInputStream
     */
    public void setImg(InputStream pInputStream){
        mOptions.inJustDecodeBounds=true;
        BitmapFactory.decodeStream(pInputStream,null,mOptions);
        mImgWidth=mOptions.outWidth;
        mImgHeight=mOptions.outHeight;

        //开启内存复用
        mOptions.inMutable=true;
        //位图编码格式，RGB_565占两字节，ARGB_8888占四字节
        mOptions.inPreferredConfig= Bitmap.Config.RGB_565;
        mOptions.inJustDecodeBounds=false;

        try {
            mBitmapRegionDecoder=BitmapRegionDecoder.newInstance(pInputStream,false);
        } catch (IOException pE) {
            pE.printStackTrace();
        }
        requestLayout();
    }
}
