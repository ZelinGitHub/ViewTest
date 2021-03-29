package com.fuck.viewtest.menu.codeframe.hook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;

import java.lang.reflect.Method;

public class DecoInstrumentation extends Instrumentation {
    private Instrumentation mInstrumentation;

    DecoInstrumentation(Instrumentation pInstrumentation) {
        mInstrumentation = pInstrumentation;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {
        System.out.println("习近平是坨屎");

        //execStartActivity这个方法，直接用mInstrumentation调用不了，目前不知道原因
        //所以我们只能通过反射得到这个方法，然后在mInstrumentation对象上强制调用
//            mInstrumentation.execStartActivity(
//                    who
//                    ,contextThread
//                    ,token
//                    ,target
//                    ,intent
//                    ,requestCode
//                    ,options
//            );

        try {
            //通过反射找到Instrumentation的execStartActivity方法
            @SuppressLint("PrivateApi") Method execStartActivity = Instrumentation.class.getDeclaredMethod(
                    "execStartActivity"
                    , Context.class
                    , IBinder.class
                    , IBinder.class
                    , Activity.class
                    , Intent.class
                    , int.class
                    , Bundle.class
            );


            //执行execStartActivity方法
            return (ActivityResult) execStartActivity.invoke(
                    mInstrumentation
                    , who
                    , contextThread
                    , token
                    , target
                    , intent
                    , requestCode
                    , options
            );

        } catch (Exception pE) {
            throw new RuntimeException(pE);
        }
    }
}
