package com.fuck.viewtest.menu.v;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

class LayoutParamsTest {

    private void createParams1() {
        int width = 100;
        int height = 200;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
    }

    private void createParams2() {
        int width = ViewGroup.LayoutParams.WRAP_CONTENT;
        int height = ViewGroup.LayoutParams.MATCH_PARENT;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(width, height);
    }

    private void getViewParams1(View pView){
        ViewGroup. LayoutParams layoutParams= pView.getLayoutParams();
    }
    private void getViewParams2(View pView){
        RelativeLayout.LayoutParams layoutParams= (RelativeLayout.LayoutParams) pView.getLayoutParams();
    }
}
