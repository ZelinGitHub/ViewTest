package com.fuck.viewtest.conprovider;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

/**
 * 通过ContentResolver的registerContentObserver方法注册ContentObserver
 * 通过unregisterContentObserver方法取消注册
 * ContentObserver在收到数据变化的通知后
 * 使用Handler通知主线程更新UI
 */
public class MyContentObserver extends ContentObserver {
    private Handler mHandler;
    /**
     * Creates a content observer.
     *
     * @param handler The handler to run {@link #onChange} on, or null if none.
     */
    public MyContentObserver(Handler handler) {
        super(handler);
        mHandler=handler;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);
    }

    @Override
    public void onChange(boolean selfChange, Uri uri) {
        super.onChange(selfChange, uri);
        mHandler.obtainMessage().sendToTarget();
    }
}
