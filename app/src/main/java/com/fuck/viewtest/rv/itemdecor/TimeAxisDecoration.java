package com.fuck.viewtest.rv.itemdecor;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;

public class TimeAxisDecoration extends RecyclerView.ItemDecoration {

    private Paint mPaint = new Paint();

    //时间轴结点的半径
    private static final float RADIUS = 40;
    private static final int AXIS_WIDTH = 100;


    @Override
    public void getItemOffsets(
            @NonNull Rect outRect
            , @NonNull View view
            , @NonNull RecyclerView parent
            , @NonNull RecyclerView.State state
    ) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.left = AXIS_WIDTH;
    }

    @Override
    public void onDraw(
            @NonNull Canvas c
            , @NonNull RecyclerView parent
            , @NonNull RecyclerView.State state
    ) {
        super.onDraw(c, parent, state);
        mPaint.setAntiAlias(true);
        mPaint.setColor(parent.getContext().getResources().getColor(R.color.white));
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int itemHeight = view.getBottom() - view.getTop();
            //时光圆X坐标
            float centerX = parent.getPaddingLeft() + AXIS_WIDTH / 2F;
            //时光圆Y坐标
            float centerY = view.getTop() + itemHeight / 2F;
            //上半截时光线的起点X坐标
            float upLineTopX = centerX;
            //上半截时光线的起点Y坐标
            float upLineTopY = view.getTop();
            //上半截时光线的终点X坐标
            float upLineBottomX = centerX;
            //上半截时光线的终点Y坐标
            float upLineBottomY = centerY - RADIUS;
            //下半截时光线的起点X坐标
            float downLineTopX = centerX;
            //下半截时光线的起点X坐标
            float downLineTopY = centerY + RADIUS;
            //下半截时光线的终点X坐标
            float downLineBottomX = centerX;
            //下半截时光线的终点X坐标
            float downLineBottomY = view.getBottom();
            //绘制上半截时间线
            c.drawLine(upLineTopX, upLineTopY, upLineBottomX, upLineBottomY, mPaint);
            //绘制时间圆
            c.drawCircle(centerX, centerY, RADIUS, mPaint);
            //绘制下半截时间线
            c.drawLine(downLineTopX, downLineTopY, downLineBottomX, downLineBottomY, mPaint);

        }
    }

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }
}
