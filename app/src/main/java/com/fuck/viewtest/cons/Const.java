package com.fuck.viewtest.cons;

public class Const {
    //schema固定为content://
    public static final String MY_CONTENT_PROVIDER_SCHEMA = "content://";
    //authority用来唯一标识ContentProvider
    public static final String MY_CONTENT_PROVIDER_AUTHORITY = "com.fuck.viewtest.conprovider.MyContentProvider";
    //path是ContentProvider背后的数据表名
    public static final String PATH_STUDENTS = "students";


    public static final String SERVER_PACKAGE ="com.example.aidlserver";


    public static final String BOOK_SERVER_PERMISSION="com.example.aidlserver.serv.BookService";
    public static final String BOOK_SERVER_INTENT_ACTION="com.example.aidlserver.serv.BookService";


    public static final String POOL_SERVER_PERMISSION="com.example.aidlserver.serv.PoolService";
    public static final String POOL_SERVER_INTENT_ACTION="com.example.aidlserver.serv.PoolService";


    public static final String MESSENGER_SERVER_PERMISSION = "com.example.aidlserver.serv.MessengerService";
    public static final String MESSENGER_SERVER_INTENT_ACTION = "com.example.aidlserver.serv.MessengerService";

    public static final int BINDER_CODE_SECURITY = 0;
    public static final int BINDER_CODE_COMPUTE = 1;

    public static final String KEY_SERVER_MSG="KEY_SERVER_MSG";
    public static final String KEY_CLIENT_MSG="KEY_CLIENT_MSG";

}
