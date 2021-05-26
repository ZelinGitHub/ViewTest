package com.fuck.viewtest.menu.view_.viewviewgroup;

import android.view.View;

public class ViewLayoutTest {
    private void layout(View v) {
        int offsetX = 100;
        int offsetY = 200;

        v.layout(
                v.getLeft() + offsetX
                , v.getTop() + offsetY
                , v.getRight() + offsetX
                , v.getBottom() + offsetY
        );

    }

}
