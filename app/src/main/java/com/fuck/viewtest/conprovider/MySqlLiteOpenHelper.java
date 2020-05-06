package com.fuck.viewtest.conprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqlLiteOpenHelper extends SQLiteOpenHelper {
    public final static String DATABASE_NAME = "edu.db";
    public final static String DATABASE_STUDENT_TABLE_NAME = "students";
    private final static int DATABASE_VERSION = 1;
    private final static String CREATE_STUDENT_TABLE = "CREATE TABLE IF NOT EXISTS "
            + DATABASE_STUDENT_TABLE_NAME
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
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(
            SQLiteDatabase db
    ) {
        db.execSQL(CREATE_STUDENT_TABLE);
    }

    @Override
    public void onUpgrade(
            SQLiteDatabase db
            , int oldVersion
            , int newVersion) {
    }
}
