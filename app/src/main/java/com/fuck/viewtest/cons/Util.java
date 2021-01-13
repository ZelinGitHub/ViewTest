package com.fuck.viewtest.cons;

import android.content.Context;
import android.widget.Toast;

public class Util {



    public static double angleToArc(double deg) {
        return deg * Math.PI / 180;
    }

    public static double arcToAngle(double deg) {
        return deg * 180 / Math.PI;
    }

    public static void toast(Context pContext, String pStr) {
        Toast.makeText(pContext, pStr, Toast.LENGTH_SHORT).show();
    }
}
