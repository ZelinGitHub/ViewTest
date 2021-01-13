package com.fuck.viewtest.menu.conprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.fuck.viewtest.cons.Const.MY_CONTENT_PROVIDER_AUTHORITY;


public class MyContentProvider extends ContentProvider {

    public static final int CODE_STUDENTS = 0;

    private SQLiteDatabase mDatabase;
    private UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);


    //运行在主线程，不能做耗时操作
    //创建ContentProvider时调用
    @Override
    public boolean onCreate() {
        mDatabase = new MySqlLiteOpenHelper(getContext())
                .getWritableDatabase();
        mUriMatcher.addURI(
                MY_CONTENT_PROVIDER_AUTHORITY
                , MySqlLiteOpenHelper.TABLE_NAME_STUDENTS
                , CODE_STUDENTS
        );
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
    public Cursor query(
            @NonNull Uri uri
            , @Nullable String[] projection
            , @Nullable String selection
            , @Nullable String[] selectionArgs
            , @Nullable String sortOrder
    ) {
        Cursor cursor = null;
        //通过Uri分辨出要查询的数据表
        int code = mUriMatcher.match(uri);
        switch (code) {
            case CODE_STUDENTS: {
                cursor = mDatabase.query(
                        MySqlLiteOpenHelper.TABLE_NAME_STUDENTS
                        , projection
                        , selection
                        , selectionArgs
                        , null
                        , null
                        , sortOrder
                        , null
                );
                break;
            }
        }
        return cursor;
    }


    //插入数据
    //运行在Binder线程池
    @Nullable
    @Override
    public Uri insert(
            @NonNull Uri uri
            , @Nullable ContentValues values
    ) {
        long rowInsert = -1;
        int code = mUriMatcher.match(uri);
        switch (code) {
            case CODE_STUDENTS: {
                rowInsert = mDatabase.insert(
                        MySqlLiteOpenHelper.TABLE_NAME_STUDENTS
                        , null
                        , values
                );
                break;
            }
        }
        if (rowInsert > -1) {
            notifyChange(uri);
        }
        return null;
    }


    //删除数据
    //运行在Binder线程池
    @Override
    public int delete(
            @NonNull Uri uri
            , @Nullable String selection
            , @Nullable String[] selectionArgs
    ) {
        int rowDelete = 0;

        int code = mUriMatcher.match(uri);
        switch (code) {
            case CODE_STUDENTS: {
                rowDelete = mDatabase.delete(
                        MySqlLiteOpenHelper.TABLE_NAME_STUDENTS
                        , selection
                        , selectionArgs
                );
                break;
            }
        }
        if (rowDelete > 0) {
            notifyChange(uri);
        }
        return rowDelete;
    }

    //更新数据
    //运行在Binder线程池
    @Override
    public int update(
            @NonNull Uri uri
            , @Nullable ContentValues values
            , @Nullable String selection
            , @Nullable String[] selectionArgs
    ) {
        int rowUpdate = 0;
        int code = mUriMatcher.match(uri);
        switch (code) {
            case CODE_STUDENTS: {
                rowUpdate = mDatabase.update(
                        MySqlLiteOpenHelper.TABLE_NAME_STUDENTS
                        , values
                        , selection
                        , selectionArgs
                );
                break;
            }
        }
        if (rowUpdate > 0) {
            notifyChange(uri);
        }
        return rowUpdate;
    }

    private void notifyChange(@NonNull Uri uri) {
        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }
    }
}
