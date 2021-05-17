package com.fuck.viewtest.menu.view_.cusview.region;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

import com.fuck.viewtest.R;

public class ClipImg extends View {
    private Bitmap mBitmap;
    private int mClipWidth = 0;
    private int mImgWidth;
    private int mImgHeight;
    private static final int CLIP_HEIGHT = 30;
    private Region mRegion = new Region();
    ;
    private Rect mRect1 = new Rect();
    private Rect mRect2 = new Rect();
    private Rect mRectA = new Rect();
    private Paint mPaint = new Paint();

    public ClipImg(Context context) {
        this(context, null);
    }

    public ClipImg(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ClipImg(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public ClipImg(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context pContext) {
        //canvas的clip相关函数必须禁止硬件加速功能
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mBitmap = BitmapFactory.decodeResource(
                getResources()
                , R.mipmap.united_kingdom
        );
        mImgWidth = mBitmap.getWidth();
        mImgHeight = mBitmap.getHeight();

    }

    //不能在onDraw函数中申请堆内存
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //清空region
        mRegion.setEmpty();
        int i = 0;
        //计算裁剪区域
        while (i * CLIP_HEIGHT <= mImgHeight) {
            //i是偶数，取余2为0
            if (i % 2 == 0) {
                mRect1.set(
                        0
                        , i * CLIP_HEIGHT
                        , mClipWidth
                        , (i + 1) * CLIP_HEIGHT
                );
                mRegion.union(mRect1);
            } else {
                mRect2.set(
                        mImgWidth - mClipWidth
                        , i * CLIP_HEIGHT
                        , mImgWidth
                        , (i + 1) * CLIP_HEIGHT
                );
                mRegion.union(mRect2);

            }
            i++;
        }
        clipRegion(canvas, mRegion);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        if (mClipWidth > mImgWidth) {
            return;
        }
        mClipWidth += 5;
//        invalidate();
    }

    //canvas.clipRegion方法已经废弃
    private void clipRegion(Canvas pCanvas, Region pRegion) {
        //regionIterator用来迭代区域内的矩形
        RegionIterator regionIterator
                = new RegionIterator(mRegion);
        while (regionIterator.next(mRectA)) {
            //裁剪出矩形
            pCanvas.clipRect(mRectA);
        }
    }
}
