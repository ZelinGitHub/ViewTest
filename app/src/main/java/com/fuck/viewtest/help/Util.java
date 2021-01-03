package com.fuck.viewtest.help;

import android.content.Context;
import android.widget.Toast;

public class Util {
    //Android中ContentProvider的Schema固定为content://
    public static final String MY_CONTENT_PROVIDER_SCHEMA = "content://";
    //Authority用来唯一标识ContentProvider
    public static final String MY_CONTENT_PROVIDER_AUTHORITY = "com.fuck.viewtest.conprovider.MyContentProvider";
    //Path就是ContentProvider背后的数据表名
    public static final String PATH_STUDENTS = "students";


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
