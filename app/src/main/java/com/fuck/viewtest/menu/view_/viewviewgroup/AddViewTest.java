package com.fuck.viewtest.menu.view_.viewviewgroup;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

class AddViewTest {

    public void fuck(Context pContext) {
        RelativeLayout relativeLayout = new RelativeLayout(pContext);
        View view = new View(pContext);
        RelativeLayout.LayoutParams layoutParams
                = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT
                , ViewGroup.LayoutParams.WRAP_CONTENT
        );
        relativeLayout.addView(view, layoutParams);
    }
}
