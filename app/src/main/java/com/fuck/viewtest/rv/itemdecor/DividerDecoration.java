package com.fuck.viewtest.rv.itemdecor;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;

public class DividerDecoration extends RecyclerView.ItemDecoration {

    private int mDividerHeight = 20;
    private Paint mPaint = new Paint();


    @Override
    public void onDraw(
            @NonNull Canvas c
            , @NonNull RecyclerView parent
            , @NonNull RecyclerView.State state
    ) {
        super.onDraw(c, parent, state);
        mPaint.setAntiAlias(true);
        mPaint.setColor(parent.getContext().getResources().getColor(R.color.redffff534BPrimary));
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            //得到ItemView
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);
            if (index != 0) {
                //分隔线左上角X坐标
                float dividerLeft = parent.getPaddingLeft();
                //分隔线左上角Y坐标
                float dividerTop = view.getTop() - mDividerHeight;
                //分隔线右下角X坐标
                float dividerRight = parent.getWidth() - parent.getPaddingRight();
                //分隔线右下角Y坐标
                float dividerBottom = view.getTop();
                //绘制矩形作为分隔线
                c.drawRect(dividerLeft,dividerTop,dividerRight,dividerBottom,mPaint);
            }
        }
    }

    @Override
    public void onDrawOver(
            @NonNull Canvas c
            , @NonNull RecyclerView parent
            , @NonNull RecyclerView.State state
    ) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(
            @NonNull Rect outRect
            , @NonNull View view
            , @NonNull RecyclerView parent
            , @NonNull RecyclerView.State state
    ) {
        super.getItemOffsets(outRect, view, parent, state);
        //第一个ItemView不需要绘制分隔线
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.top = mDividerHeight;
        }
    }
}
