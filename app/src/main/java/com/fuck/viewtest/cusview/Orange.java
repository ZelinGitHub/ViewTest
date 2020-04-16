package com.fuck.viewtest.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

public class Orange extends View {
    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Rect mRectA=new Rect();
    private Path mPath = new Path();
    private RectF mRectF = new RectF();
    private Region mRegion=new Region();
    private Region mRegionA=new Region();
//    private RegionIterator mRegionIterator=new RegionIterator(mRegion);

    public Orange(Context context) {
        super(context);
    }

    public Orange(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Orange(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColor(0xFFFF0000);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10);
//        canvas.drawCircle(190,200,150,mPaint);
//
//        mPaint.setColor(0x7EFFFF00);
//        canvas.drawCircle(190,200,100,mPaint);
//
//        canvas.drawRGB(0xFF,0x00,0xFF);
//        canvas.drawColor(0xFFFF00FF);
//        canvas.drawARGB(0xFF,0xFF,0,0xFF);
//
//        canvas.drawLine(400,400,1200,1200,mPaint);

//        canvas.drawPoint(100, 100, mPaint);
//
//        mRect.set(10, 10, 100, 100);
//        canvas.drawRect(mRect, mPaint);
//
//        int myColor = Color.argb(22, 222, 34, 34);
//        int colorRed = Color.RED;
//        int red = Color.red(0xFF000F00);

//        mPath.moveTo(400, 0);
//        mPaint.setColor(Color.BLUE);
//        mPath.lineTo(50, 500);
//        mPaint.setColor(Color.RED);
//        mPath.lineTo(800, 600);
//
//
//        mPath.close();
//        canvas.drawPath(mPath, mPaint);

//        mRectF.set(50,50,850,1050);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(mRectF,mPaint);
//        mPaint.setColor(Color.BLACK);
//        canvas.drawOval(mRectF,mPaint);
//        canvas.drawArc(mRectF,0,120,true,mPaint);
//        canvas.drawRoundRect(mRectF,50,50,mPaint);
//        canvas.drawCircle(800,1000,500,mPaint);
//
//        mPaint.setColor(Color.GREEN);
//        canvas.drawOval(mRectF,mPaint);
//

//        mPath.moveTo(10,10);
//        mPath.arcTo(mRectF,0,120);
//        mPath.close();
//        canvas.drawPath(mPath,mPaint);

        mRect.set(250,450,1000,1800);

        mRegion.set(mRect);
        canvas.drawColor(Color.RED);
        clipRegion(canvas,mRegion);
//        canvas.clipRect(mRect);
        canvas.drawColor(Color.BLUE);
//        mRectF.set(50,50,800,1200);
//        mPath.addOval(mRectF,Path.Direction.CCW);
//
//        mRect.set(50,50,800,400);
//        mRegionA.set(mRect);
//
//        mRegion.setPath(mPath,mRegionA);
//        @SuppressLint("DrawAllocation")
//        RegionIterator regionIterator=new RegionIterator(mRegion);
//
//        while(regionIterator.next(mRectA)){
//            canvas.drawRect(mRectA,mPaint);
//        }


//
//        mRect.set(0,0,800,2000);
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(mRect,mPaint);
//        canvas.save();
//
//        canvas.rotate(30,500,500);
//        mPaint.setColor(Color.YELLOW);
//        canvas.drawRect(mRect,mPaint);
//        canvas.save();
//
//        canvas.translate(500,500);
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(mRect,mPaint);
//
//        canvas.restore();
//        canvas.restore();
//        mPaint.setColor(Color.GREEN);
//        canvas.drawRect(mRect,mPaint);

//        canvas.drawColor(Color.BLACK);
//        canvas.save();
//
//        canvas.drawColor(Color.RED);
//        canvas.restore();

        Paint.FontMetrics fontMetrics;
    }

    //canvas.clipRegion方法已经废弃
    private void clipRegion(Canvas pCanvas,Region pRegion){
        //regionIterator用来迭代区域内的矩形
        RegionIterator regionIterator
                =new RegionIterator(pRegion);
        while(regionIterator.next(mRectA)){
            //裁剪出矩形
            pCanvas.clipRect(mRectA);
        }
    }
}
