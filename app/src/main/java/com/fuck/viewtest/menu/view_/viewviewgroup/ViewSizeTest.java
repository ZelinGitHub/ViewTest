package com.fuck.viewtest.menu.view_.viewviewgroup;

import android.view.View;

public class ViewSizeTest {

    private void getSize(View v) {
        int width = v.getRight() - v.getLeft();
        int height = v.getBottom() - v.getTop();
        int width2 = v.getWidth();
        int height2 = v.getHeight();
    }
}
