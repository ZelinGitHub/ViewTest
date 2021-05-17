package com.fuck.viewtest.menu.view_.viewviewgroup;

import android.view.View;
import android.view.ViewTreeObserver;

public class ViewTreeObserverTest {
    private void viewTreeObserver(final View pV) {
        ViewTreeObserver observer = pV.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                pV.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int measureWidth = pV.getMeasuredWidth();
                int measureHeight = pV.getMeasuredHeight();
                int width = pV.getWidth();
                int height = pV.getHeight();
            }
        });
    }
}
