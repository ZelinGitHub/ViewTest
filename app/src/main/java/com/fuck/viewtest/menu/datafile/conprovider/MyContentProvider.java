package com.fuck.viewtest.menu.datafile.conprovider;

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

    //定义数据源表格Code
    public static final int CODE_STUDENTS = 0;

    private SQLiteDatabase mDatabase;
    //创建UriMatcher
    private final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);


    //（1）创建数据库
    //（2）为UriMatcher增加Uri，参数是authority、path、表格code
    //（3）返回true
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


    //不关心MIME类型，返回null
    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }


    //（1）通过参数Uri分辨出要操作的表格
    //（2）执行数据库的查询语句，返回查询结果
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


    //（1）通过参数Uri分辨出要操作的表格
    //（2）执行数据库的插入语句，得到插入行数
    //（3）如果插入行数大于-1，通知ContentResolver数据更新，要监听这个更新，需要使用ContentObserver
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


    //（1）通过参数Uri分辨出要操作的表格
    //（2）执行数据库的删除语句，得到删除行数
    //（3）如果删除行数大于0，通知ContentResolver数据更新，要监听这个更新，需要使用ContentObserver
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


    //（1）通过参数Uri分辨出要操作的表格
    //（2）执行数据库的更新语句，得到更新行数
    //（3）如果更新行数大于0，通知ContentResolver数据更新，要监听这个更新，需要使用ContentObserver
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

    //通知ContentResolver数据更新
    //要监听这个更新，需要使用ContentObserver
    private void notifyChange(@NonNull Uri uri) {
        Context context = getContext();
        if (context != null) {
            context.getContentResolver().notifyChange(uri, null);
        }
    }
}
