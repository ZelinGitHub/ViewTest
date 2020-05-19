package com.fuck.viewtest.cusview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.fuck.viewtest.R;

/**
 * 通过裁剪画布，根据方形图产生圆形图
 */
public class CircleImg extends View {
    private Bitmap mBitmap;
    private Paint mPaint = new Paint();
    ;
    private Path mPath = new Path();
    ;


    public CircleImg(Context context) {
        this(context, null);
    }


    public CircleImg(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleImg(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public CircleImg(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context pContext) {
        //使用canvas clip系列函数时，要禁用硬件加速功能
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.united_kingdom);
        float bitmapWidth = mBitmap.getWidth();
        float bitmapHeight = mBitmap.getHeight();
        mPath.addCircle(bitmapWidth / 2, bitmapHeight / 2, bitmapHeight / 2, Path.Direction.CCW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //保存canvas状态
        canvas.save();
        //先将canvas裁剪成圆形，再将位图画上去
        canvas.clipPath(mPath);
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);
        //复原裁剪前的canvas状态
        canvas.restore();
    }
}
