package com.fuck.viewtest.menu.codeframe.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;

import com.fuck.viewtest.R;

import java.lang.reflect.Field;

import androidx.appcompat.app.AppCompatActivity;

public class SuckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suck);
    }

    private void startAtyFromAty(Activity pActivity) {
        replaceActivityInstrumentation(pActivity);
        startActivity(FuckActivity.newIntent(pActivity));
    }

    public void startAtyFromContext(){
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
            //得到字段在指定对象中的值，也就是字段引用的被装饰类的实例
            Instrumentation instrumentation = (Instrumentation) field.get(pActivity);
            //创建装饰器
            Instrumentation decoInstrumentation = new DecoInstrumentation(instrumentation);
            //改变字段值，使其引用装饰器实例，而非被装饰类的实例
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
