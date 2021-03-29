package com.fuck.viewtest.menu.codeframe.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

import java.lang.reflect.Field;

public class SuckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suck);

//        replaceActivityInstrumentation(this);
        //        startActivity(FuckActivity.newIntent(this));

        replaceContextInstrumentation();
        Intent intent=FuckActivity.newIntent(this);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);
    }

    private void replaceActivityInstrumentation(Activity pActivity) {

        try {
            //通过反射得到Activity的mInstrumentation字段
            Field field = Activity.class.getDeclaredField("mInstrumentation");
            field.setAccessible(true);

            //得到指定对象的字段值
            Instrumentation instrumentation = (Instrumentation) field.get(pActivity);
            //得到Instrumentation装饰类的对象
            Instrumentation decoInstrumentation = new DecoInstrumentation(instrumentation);
            //替换mInstrumentation为装饰类对象
            field.set(pActivity, decoInstrumentation);
        } catch (NoSuchFieldException pE) {
            pE.printStackTrace();
        } catch (IllegalAccessException pE) {
            pE.printStackTrace();
        }
    }

    private void replaceContextInstrumentation() {
        try {
            //我们无法直接使用ActivityThread类，只能通过Class.forName得到ActivityThread的clazz
            Class<?> activityThreadClazz = Class.forName(
                    "android.app.ActivityThread"
            );

            //sCurrentActivityThread字段保存了当前ActivityThread的对象
            //sCurrentActivityThread是ActivityThread的静态字段
            Field activityThreadField = activityThreadClazz.getDeclaredField(
                    "sCurrentActivityThread"
            );
            activityThreadField.setAccessible(true);
            //得到activityThreadField字段值，也就是当前ActivityThread对象
            Object currentActivityThread = activityThreadField.get(null);


            //得到ActivityThread的mInstrumentation字段
            Field instrumentationField = activityThreadClazz.getDeclaredField(
                    "mInstrumentation"
            );
            instrumentationField.setAccessible(true);
            //得到ActivityThread的mInstrumentation字段值
            Instrumentation instrumentation = (Instrumentation) instrumentationField.get(currentActivityThread);
            //得到装饰类对象
            Instrumentation decoInstrumentation = new DecoInstrumentation(instrumentation);

            //设置ActivityThread的mInstrumentation字段的值为装饰类对象
            instrumentationField.set(currentActivityThread, decoInstrumentation);
        } catch (ClassNotFoundException pE) {
            pE.printStackTrace();
        } catch (NoSuchFieldException pE) {
            pE.printStackTrace();
        } catch (IllegalAccessException pE) {
            pE.printStackTrace();
        }
    }
}
