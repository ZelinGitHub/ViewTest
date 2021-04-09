package com.fuck.viewtest.menu.view_.textview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

/**
 * 使TextView中不同大小字体居中对齐
 */
public class MiddleTextSpan extends ReplacementSpan {

    private final float mFontSizePx;    //px

    public MiddleTextSpan(float fontSizePx) {
        this.mFontSizePx = fontSizePx;
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        String str = text.subSequence(start, end).toString();
        Paint paint1 = getCustomTextPaint(paint);
        return (int) paint1.measureText(str);
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        String str = text.subSequence(start, end).toString();
        Paint paint1 = getCustomTextPaint(paint);
        Paint.FontMetrics fontMetrics = paint1.getFontMetrics();
        //基于文本顶部坐标系的中点坐标
        int center = bottom / 2;
        //定点写字，给定中心点
        float y1 = center + (fontMetrics.bottom - fontMetrics.top) / 2 - fontMetrics.bottom;
        canvas.drawText(str, x, y1, paint1);
    }

    private TextPaint getCustomTextPaint(Paint srcPaint) {
        TextPaint textPaint = new TextPaint(srcPaint);
        textPaint.setTextSize(mFontSizePx);   //设定字体大小, sp转换为px
        return textPaint;
    }
}

