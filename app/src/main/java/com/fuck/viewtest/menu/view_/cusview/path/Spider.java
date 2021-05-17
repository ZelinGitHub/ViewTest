package com.fuck.viewtest.menu.view_.cusview.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import static com.fuck.viewtest.cons.Util.angleToArc;

/**
 * 蛛网图控件
 */
public class Spider extends View {
    //绘制网格
    private Paint mWebPaint = new Paint();
    //绘制内容
    private Paint mContentPaint = new Paint();
    //半径
    private float mRadius;
    private int mCenterX;
    private int mCenterY;
    private Path mPath = new Path();
    //网格间距
    private float mGap;
    private static final int LATITUDE_NUM = 6;
    private static final int LONGITUDE_NUM = 6;
    //蛛网面积占当前控件的90%
    private static final double WEB_AREA_RATIO = 0.9;
    private static final int LATITUDE_WIDTH = 10;
    public int[] mData = new int[LONGITUDE_NUM];
    private static final int MAX_VALUE = 6;

    public Spider(Context context) {
        this(context, null);
    }


    public Spider(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Spider(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public Spider(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context pContext) {

        mWebPaint.setStyle(Paint.Style.STROKE);
        mWebPaint.setColor(Color.BLUE);
        mWebPaint.setStrokeWidth(LATITUDE_WIDTH);

        mContentPaint.setColor(Color.RED);
        mContentPaint.setStyle(Paint.Style.FILL);
        mContentPaint.setAlpha(127);

        mData[0] = 1;
        mData[1] = 2;
        mData[2] = 3;
        mData[3] = 4;
        mData[4] = 5;
        mData[5] = 6;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);

        mRadius = (float) (Math.min((float) w, h) / 2 * WEB_AREA_RATIO);
        mGap = mRadius / LATITUDE_NUM;
        mCenterX = w / 2;
        mCenterY = h / 2;
    }

    @Override
    protected void onDraw(Canvas pCanvas) {
        super.onDraw(pCanvas);
        //绘制纬度线
        drawLatitudes(pCanvas);
        //绘制经度线
        drawLongitudes(pCanvas);
        //绘制数据图
        drawContent(pCanvas);
    }


    /**
     * 网格是通过moveTo和lineTo一圈一圈画出来的
     * 需要计算每个转折点的坐标
     * 转折点和中心的连线称为转折点连线
     * 转折点连线和x轴夹角定义为α
     * 如果网格是六边形，α角度依次为0、60、120、180、240、300
     * m是总层数，如果转折点a位于向外第n层，转折点连线长度len=n/m*mRadius
     * a的横坐标为x，a的纵坐标为y
     * x=mCenterX+len*cos(α)，y=mCenterY+len*sin(α)
     *
     * @param pCanvas 画布
     */
    private void drawLatitudes(Canvas pCanvas) {
        for (int i = 0; i < LATITUDE_NUM; i++) {
            //清空path数据
            mPath.reset();
            float curtRadius = mGap * (i + 1);
            //清除path所有数据和数据结构，不会清除填充模式
            for (int j = 0; j < LONGITUDE_NUM; j++) {
                if (j == 0) {
                    //为0时不用绘制
                    //重置path起点
                    mPath.moveTo(mCenterX + curtRadius, mCenterY);
                } else {
                    double angle = angleToArc((double) 360 / LONGITUDE_NUM * j);
                    //注意，Math.cos和Math.sin的参数是弧度，不是角度
                    double dx = curtRadius * Math.cos(angle);
                    double dy = curtRadius * Math.sin(angle);

                    float x = (float) (mCenterX + dx);
                    float y = (float) (mCenterY + dy);
                    //连接直线
                    mPath.lineTo(x, y);
                }
            }
            //闭合path，否则少连一条直线
            mPath.close();
            pCanvas.drawPath(mPath, mWebPaint);
        }
    }

    private void drawLongitudes(Canvas pCanvas) {
        for (int i = 0; i < LONGITUDE_NUM; i++) {
            //清空path数据
            mPath.reset();
            //重置path起点
            mPath.moveTo(mCenterX, mCenterY);
            double angle = angleToArc((double) 360 / LONGITUDE_NUM * i);
            float x = (float) (mCenterX + mRadius * Math.cos(angle));
            float y = (float) (mCenterX + mRadius * Math.sin(angle));
            //连接直线
            mPath.lineTo(x, y);
            pCanvas.drawPath(mPath, mWebPaint);
        }

    }


    private void drawContent(Canvas pCanvas) {
        for (int i = 0; i < LONGITUDE_NUM; i++) {
            //数据值比例
            double per = (double) mData[i] / MAX_VALUE;
            //经线角度
            double angle = angleToArc((double) 360 / LONGITUDE_NUM * i);
            //点在经线上的坐标
            float x = (float) (mCenterX + mRadius * Math.cos(angle) * per);
            float y = (float) (mCenterY + mRadius * Math.sin(angle) * per);

            if (i == 0) {
                //为0时不绘制
                //重置path起点
                mPath.moveTo(x, mCenterY);
            } else {
                //连接直线
                mPath.lineTo(x, y);
            }
            //绘制实心圆点
            pCanvas.drawCircle(x, y, 15, mContentPaint);
        }
        mContentPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        //绘制实心path
        pCanvas.drawPath(mPath, mContentPaint);
    }


}
