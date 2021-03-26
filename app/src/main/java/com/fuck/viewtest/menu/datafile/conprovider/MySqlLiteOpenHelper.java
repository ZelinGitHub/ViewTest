package com.fuck.viewtest.menu.datafile.conprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqlLiteOpenHelper extends SQLiteOpenHelper {
    //定义库名
    public final static String DATABASE_NAME = "edu.db";
    //定义表名
    public final static String TABLE_NAME_STUDENTS = "students";
    //定义数据库版本
    private final static int DATABASE_VERSION = 1;
    //定义建表语句
    private final static String CREATE_STUDENT_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME_STUDENTS
            + "("
            + "id INTEGER PRIMARY KEY,"
            + "name TEXT VARCHAR(20) NOT NULL,"
            + "gender BIT DEFAULT(1),"
            + "number TEXT VARCHAR(12) NOT NULL,"
            + "score INTEGER CHECK(score >= 0 and score <= 100)"
            + ")";

    public MySqlLiteOpenHelper(
            @Nullable Context context
    ) {
        //调用父类构造方法
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(
            SQLiteDatabase db
    ) {
        //创建表
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(
            SQLiteDatabase db
            , int oldVersion
            , int newVersion) {
    }
}
