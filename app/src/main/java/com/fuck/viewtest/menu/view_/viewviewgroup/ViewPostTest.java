package com.fuck.viewtest.menu.view_.viewviewgroup;

import android.view.View;

public class ViewPostTest {
    private void viewPost(final View pV) {
        pV.post(new Runnable() {
            @Override
            public void run() {
                int measureWidth = pV.getMeasuredWidth();
                int measureHeight = pV.getMeasuredHeight();
                int width = pV.getWidth();
                int height = pV.getHeight();
            }
        });
    }
}
