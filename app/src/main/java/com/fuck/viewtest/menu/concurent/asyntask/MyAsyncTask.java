package com.fuck.viewtest.menu.concurent.asyntask;

import android.os.AsyncTask;

public class MyAsyncTask extends AsyncTask<String,String,String> {
    @Override
    protected String doInBackground(String... pStrings) {
        return "正在进行";
    }
}
