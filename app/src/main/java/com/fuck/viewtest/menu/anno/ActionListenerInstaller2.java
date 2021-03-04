package com.fuck.viewtest.menu.anno;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ActionListenerInstaller2 {

    //得到被注解的方法，和注解中传入的控件
    public static void processAnnotations(Object obj) {
        try {
            //得到目标对象的类的Class，目标对象是一个Activity
            Class<?> cls = obj.getClass();
            //遍历Class的所有Method
            for (Method method : cls.getDeclaredMethods()) {
                //得到指定方法上的注解实例
                //拥有ActionListenerFor注解的Method是点击回调
                ActionListenerFor actionListenerFor = method.getAnnotation(ActionListenerFor.class);
                if (actionListenerFor != null) {
                    //调用注解的方法
                    //得到注解的参数值
                    //元素值是一个控件的名字
                    String source = actionListenerFor.source();
                    //得到指定的域
                    Field field = cls.getDeclaredField(source);
                    //设置这个域可访问
                    field.setAccessible(true);
                    //得到这个域在当前对象上的值，这个值是个控件
                    Object fieldValue = field.get(obj);
                    if (fieldValue != null) {
                        //为控件设置监听
                        addListener(fieldValue, obj, method);
                    }
                }
            }
        } catch (ReflectiveOperationException pE) {
            pE.printStackTrace();
        }
    }


    //为控件设置点击监听
    public static void addListener(Object pSource, final Object pParam, final Method pMethod) {
        try {
            //创建OnClickListener实现类的实例
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        pMethod.invoke(pParam);
                    } catch (IllegalAccessException | InvocationTargetException pE) {
                        pE.printStackTrace();
                    }
                }
            };
            //得到View的Class
            Class<?> sourceCls = pSource.getClass();
            //得到View的setOnClickListener方法的Method
            Method setOnClickListenerMethod = null;
            setOnClickListenerMethod = sourceCls.getMethod("setOnClickListener", View.OnClickListener.class);
            //调用View的setOnClickListener方法，为View设置OnClickListener
            setOnClickListenerMethod.invoke(pSource, listener);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException pE) {
            pE.printStackTrace();
        }
    }
}
