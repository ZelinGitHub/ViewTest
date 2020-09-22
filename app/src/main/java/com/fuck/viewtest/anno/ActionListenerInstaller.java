package com.fuck.viewtest.anno;

import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ActionListenerInstaller {
    public static void processAnnotations(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            for (Method method : cls.getDeclaredMethods()) {
                //得到指定方法上的注解对象
                ActionListenerFor actionListenerFor = method.getAnnotation(ActionListenerFor.class);
                if (actionListenerFor != null) {
                    //得到注解的元素值
                    String source = actionListenerFor.source();
                    //得到指定的域
                    Field field = cls.getDeclaredField(source);
                    field.setAccessible(true);
                    //得到这个域在当前对象上的值，这个值应该是个View
                    Object fieldValue = field.get(obj);
                    //为View设置监听
                    addListener(fieldValue, obj, method);
                }
            }
        } catch (ReflectiveOperationException pE) {
            pE.printStackTrace();
        }
    }

    public static void addListener(Object pSource, final Object pParam, final Method pMethod) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //InvocationHandler的invoke方法调用参数传入的pMethod方法
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
                return pMethod.invoke(pParam);
            }
        };
        //创建代理
        //动态定义了OnClickListener接口的实现类
        //创建OnClickListener实现类的对象
        //参数loader传null，使用默认的类加载器
        //OnClickListener的onClick方法调用InvocationHandler的invoke方法
        Object listener = Proxy.newProxyInstance(
                null
                , new Class[]{View.OnClickListener.class}
                , invocationHandler
        );
        Class<?> sourceCls = pSource.getClass();
        Method setOnClickListenerMethod= sourceCls.getMethod("setOnClickListener",View.OnClickListener.class);
        //调用View的setOnClickListener方法，为View设置OnClickListener
        //View在被点击时，内部会调用参数listener的onClick方法
        setOnClickListenerMethod.invoke(pSource, listener);
    }
}
