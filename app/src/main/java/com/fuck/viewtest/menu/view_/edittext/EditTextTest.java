package com.fuck.viewtest.menu.view_.edittext;

import android.os.Build;
import android.text.InputType;
import android.widget.EditText;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EditTextTest {
    public static void hideSystemSoftKeyboard(EditText editText) {
        editText.setShowSoftInputOnFocus(false);


        int sdkInt = Build.VERSION.SDK_INT;
        if (sdkInt >= 11) {
            try {
                Class<EditText> cls = EditText.class;
                Method setShowSoftInputOnFocus;
                setShowSoftInputOnFocus = cls.getMethod("setShowSoftInputOnFocus", boolean.class);
                setShowSoftInputOnFocus.setAccessible(true);
                setShowSoftInputOnFocus.invoke(editText, false);
            } catch (
                    SecurityException
                            | NoSuchMethodException
                            | IllegalAccessException
                            | InvocationTargetException e
            ) {
                e.printStackTrace();
            }
        } else {
            editText.setInputType(InputType.TYPE_NULL);
        }
    }
}
