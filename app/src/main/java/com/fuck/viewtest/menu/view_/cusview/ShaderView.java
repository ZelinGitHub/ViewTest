package com.fuck.viewtest.menu.view_.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ShaderView extends View {

    private Paint mPaint = new Paint();

    public ShaderView(Context context) {
        this(context, null);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public ShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
//        LinearGradient linearGradient = new LinearGradient(
//                0
//                , getHeight()/2F
//                , getWidth()
//                , getHeight()/2F
//                , 0xffff0000
//                , 0xff00ff00
//                , Shader.TileMode.MIRROR
//        );
//        mPaint.setShader(linearGradient);
//        mPaint.setStyle(Paint.Style.FILL);


        LinearGradient linearGradient = new LinearGradient(0,0,3000,0, Color.BLACK,Color.WHITE, Shader.TileMode.CLAMP);
        mPaint.setShader(linearGradient);



    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRect(0, 0, getWidth(), getHeight(), mPaint);
        canvas.drawRect(0,0,2000,2000,mPaint);
    }
}
