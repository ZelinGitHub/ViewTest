package com.fuck.viewtest.menu.conprovider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;

import static com.fuck.viewtest.cons.Const.MY_CONTENT_PROVIDER_AUTHORITY;
import static com.fuck.viewtest.cons.Const.MY_CONTENT_PROVIDER_SCHEMA;
import static com.fuck.viewtest.cons.Const.PATH_STUDENTS;


public class ContentProviderAty extends AppCompatActivity implements View.OnClickListener {

    //ContentProvider背后数据表的Uri
    private static final Uri URI_STUDENTS = Uri.parse(
            MY_CONTENT_PROVIDER_SCHEMA
                    + MY_CONTENT_PROVIDER_AUTHORITY
                    + "/"
                    + PATH_STUDENTS
    );

    private ContentObserver mContentObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_provider);
        initViews();
        initUI();
    }

    private void initViews() {

    }

    private void initUI() {
        MyObserverHandler handler = new MyObserverHandler();
        mContentObserver = new MyContentObserver(handler);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ContentResolver contentResolver = getContentResolver();
        contentResolver.registerContentObserver(URI_STUDENTS, true, mContentObserver);
    }


    @Override
    protected void onPause() {
        super.onPause();
        ContentResolver contentResolver = getContentResolver();
        contentResolver.unregisterContentObserver(mContentObserver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }


    //得到ContentResolver
    //创建ContentValues
    //设置ContentValues
    //调用ContentResolver的insert方法，传入表格URI和ContentValues
    private void insertValue(Context pContext) {
        ContentResolver contentResolver = pContext.getContentResolver();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", 0);
        contentValues.put("name", "peter");
        contentValues.put("gender", 0);
        contentValues.put("number", "201804081705");
        contentValues.put("score", "100");
        contentResolver.insert(URI_STUDENTS, contentValues);
    }

    private void queryValue() {
        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(URI_STUDENTS, new String[]{"id", "name", "gender", "number", "score"}, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                Student student = new Student();
                student.id = cursor.getInt(cursor.getColumnIndex("id"));
                student.name = cursor.getString(cursor.getColumnIndex("name"));
                student.gender = cursor.getInt(cursor.getColumnIndex("gender"));
                student.number = cursor.getString(cursor.getColumnIndex("number"));
                student.score = cursor.getInt(cursor.getColumnIndex("score"));
            }
            cursor.close();
        }

    }

    private void updateValue() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", 0);
        contentValues.put("name", "update");
        contentValues.put("gender", 1);
        contentValues.put("number", "201804111048");
        contentValues.put("score", "90");
        ContentResolver contentResolver = getContentResolver();
        contentResolver.update(URI_STUDENTS, contentValues, "id = ?", new String[]{"0"});
    }

    private void deleteValue() {
        ContentResolver contentResolver = getContentResolver();
        contentResolver.delete(URI_STUDENTS, "name = ?", new String[]{"update"});
    }

}
