package com.fuck.viewtest.rv.itemdecor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fuck.viewtest.R;

public class FlagDecoration extends RecyclerView.ItemDecoration {


    private Paint mPaint = new Paint();

    private static final float FLAG_LEFT = 200;

    @Override
    public void onDrawOver(
            @NonNull Canvas c
            , @NonNull RecyclerView parent
            , @NonNull RecyclerView.State state
    ) {
        super.onDrawOver(c, parent, state);
        Bitmap icon = BitmapFactory.decodeResource(
                parent.getContext().getResources()
                , R.mipmap.flag
        );

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = parent.getChildAt(i);
            int index = parent.getChildAdapterPosition(view);
            //为前三个条目绘制旗帜
            if (index < 3) {
                c.drawBitmap(icon, FLAG_LEFT, view.getTop(), mPaint);
            }
        }
    }
}
