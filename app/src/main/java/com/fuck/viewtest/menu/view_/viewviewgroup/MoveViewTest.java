package com.fuck.viewtest.menu.view_.viewviewgroup;

import android.view.View;

public class MoveViewTest {

    private void moveView(View pV) {
        System.out.println("View原始坐标：" + pV.getLeft() + " " + pV.getTop() + " " + pV.getRight() + " " + pV.getBottom());
        System.out.println("View当前坐标：" + pV.getX() + " " + pV.getY());
        pV.setX(500);
        pV.setY(500);
        System.out.println("View原始坐标：" + pV.getLeft() + " " + pV.getTop() + " " + pV.getRight() + " " + pV.getBottom());
        System.out.println("View当前坐标：" + pV.getX() + " " + pV.getY());
        pV.setTranslationX(200);
        pV.setTranslationY(200);
        System.out.println("View原始坐标：" + pV.getLeft() + " " + pV.getTop());
        System.out.println("View当前坐标：" + pV.getX() + " " + pV.getY());
        pV.setTranslationX(200);
        pV.setTranslationY(1200);
        System.out.println("View原始坐标：" + pV.getLeft() + " " + pV.getTop());
        System.out.println("View当前坐标：" + pV.getX() + " " + pV.getY());

        pV.offsetLeftAndRight(300);
        pV.offsetTopAndBottom(300);
        System.out.println("View原始坐标：" + pV.getLeft() + " " + pV.getTop());
        System.out.println("View当前坐标：" + pV.getX() + " " + pV.getY());
    }
}
