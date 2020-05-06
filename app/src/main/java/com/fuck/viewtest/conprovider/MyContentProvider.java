package com.fuck.viewtest.conprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyContentProvider extends ContentProvider {

    private SQLiteDatabase mDatabase;

    //运行在主线程，不能做耗时操作
    //创建ContentProvider时调用
    @Override
    public boolean onCreate() {
        mDatabase=new MySqlLiteOpenHelper(getContext()).getWritableDatabase();
        return true;
    }

    //获得数据的mime类型
    //运行在Binder线程池
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }
    //查询数据
    //运行在Binder线程池
    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }


    //插入数据
    //运行在Binder线程池
    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    //删除数据
    //运行在Binder线程池
    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    //更新数据
    //运行在Binder线程池
    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
