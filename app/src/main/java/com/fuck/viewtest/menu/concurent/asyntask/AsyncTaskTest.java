package com.fuck.viewtest.menu.concurent.asyntask;

public class AsyncTaskTest {
    public static void test(){
        MyAsyncTask asyncTask=new MyAsyncTask();
        asyncTask.execute("Faker");
        asyncTask.cancel(true);
    }

}
