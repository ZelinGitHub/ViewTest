package com.fuck.viewtest.menu.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aidlserver.IBookClientMgr;
import com.example.aidlserver.IBookServerMgr;
import com.example.aidlserver.bean.Book;
import com.fuck.viewtest.R;
import com.fuck.viewtest.cons.Const;

public class BookClientAty extends AppCompatActivity implements View.OnClickListener {
    private Button btn_bind_book_server;
    private Button btn_add_book;
    private Button btn_remove_book;
    private Button btn_find_book;
    private Button btn_add_binder;
    private Button btn_unbind_book_server;


    private IBookServerMgr mProxy;
    private BookServiceConnection mBookServiceConnection = new BookServiceConnection();

    private int mLevel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_client);
        initViews();
        initUI();
    }

    private void initViews() {
        btn_bind_book_server = findViewById(R.id.btn_bind_book_server);
        btn_add_book = findViewById(R.id.btn_add_book_on_server);
        btn_remove_book = findViewById(R.id.btn_remove_book_on_server);
        btn_find_book = findViewById(R.id.btn_find_book_on_server);
        btn_add_binder = findViewById(R.id.btn_set_clientbinder_on_server);
        btn_unbind_book_server = findViewById(R.id.btn_unbind_book_server);

    }

    private void initUI() {
        btn_bind_book_server.setOnClickListener(this);
        btn_add_book.setOnClickListener(this);
        btn_remove_book.setOnClickListener(this);
        btn_find_book.setOnClickListener(this);
        btn_add_binder.setOnClickListener(this);
        btn_unbind_book_server.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_bind_book_server: {

                bindBookServer(this);
                break;
            }
            case R.id.btn_add_book_on_server: {
                addBookOnServer();
                break;
            }
            case R.id.btn_remove_book_on_server: {
                removeBookOnServer();
                break;
            }
            case R.id.btn_find_book_on_server: {
                findBookOnServer();
                break;
            }
            case R.id.btn_set_clientbinder_on_server: {
                setClientBinderOnServer();
                break;
            }
            case R.id.btn_unbind_book_server: {
                unbindBookServer(this);
                break;
            }

        }
    }


    private void bindBookServer(Context pContext) {
        if (mProxy == null) {
            System.out.println("客户端 连接服务端");
            Intent intent = new Intent();
            intent.setAction(Const.BOOK_SERVER_INTENT_ACTION);
            intent.setPackage(Const.SERVER_PACKAGE);
            pContext.bindService(intent, mBookServiceConnection, Context.BIND_AUTO_CREATE);
        } else {
            System.out.println("客户端 和服务端的连接已存在");
        }

    }

    private void addBookOnServer() {
        if (mProxy != null) {
            //IPC方法可能会阻塞，需要在子线程调用
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Book book = new Book();
                        book.name = "基督山伯爵";
                        book.code = 1;
                        System.out.println("客户端 远程添加书 " + book.toString());
                        mProxy.addBook(book);
                    } catch (RemoteException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        } else {
            System.out.println("客户端 没有连接到服务端");
        }

    }

    private void removeBookOnServer() {
        if (mProxy != null) {
            //IPC方法可能会阻塞，需要在子线程调用
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("客户端 远程删除书");
                        Book book = mProxy.removeBook();
                        if (book != null) {
                            System.out.println("客户端 远程删除书 " + book.toString() + " 成功");
                        } else {
                            System.out.println("客户端 远程删除书失败");
                        }
                    } catch (RemoteException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        } else {
            System.out.println("客户端 没有连接到服务端");
        }

    }

    private void findBookOnServer() {
        if (mProxy != null) {
            //IPC方法可能会阻塞，需要在子线程调用
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String name = "基督山伯爵";
                        System.out.println("客户端 远程查询书 " + name);
                        boolean isHaveBook = mProxy.isHaveBook(name);
                        if (isHaveBook) {
                            System.out.println("客户端 远程查询书成功");
                        } else {
                            System.out.println("客户端 远程查询书失败");
                        }
                    } catch (RemoteException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        } else {
            System.out.println("客户端 没有连接到服务端");
        }

    }

    private void setClientBinderOnServer() {
        if (mProxy != null) {
            //IPC方法可能会阻塞，需要在子线程调用
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        BookClientBinder bookClientBinder = new BookClientBinder();
                        System.out.println("客户端 远程设置客户端Binder");
                        mProxy.setClientBinder(bookClientBinder);
                    } catch (RemoteException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();
        } else {
            System.out.println("客户端 没有连接到服务端");
        }
    }

    private void unbindBookServer(Context pContext) {
        if (mProxy != null) {
            System.out.println("客户端 断开和服务端的连接");
            pContext.unbindService(mBookServiceConnection);
            mProxy = null;
        } else {
            System.out.println("客户端 没有连接到服务端");
        }
    }

    class BookServiceConnection implements ServiceConnection {

        public BookServiceConnection() {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {

            mProxy = IBookServerMgr.Stub.asInterface(service);
            System.out.println("客户端 连接到服务端成功");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        BookDeathRecipient bookDeathRecipient = new BookDeathRecipient(service);
                        //注册死亡监听，注意这里使用的是Stub，而不是Stub的代理Proxy
                        System.out.println("客户端 远程注册服务端Binder的死亡监听");
                        service.linkToDeath(bookDeathRecipient, 0);
                    } catch (RemoteException pE) {
                        pE.printStackTrace();
                    }
                }
            }).start();

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            System.out.println("客户端 和服务端断开连接");
            mProxy = null;
        }
    }

    class BookClientBinder extends IBookClientMgr.Stub {

        @Override
        public int getLevel() throws RemoteException {
            System.out.println("客户端 当前等级是 " + mLevel);
            return mLevel;
        }

        @Override
        public void setLevel(int level) throws RemoteException {
            mLevel = level;
            System.out.println("客户端 新等级是 " + mLevel);
        }
    }

    static class BookDeathRecipient implements IBinder.DeathRecipient {
        private IBinder mServerBinder;

        public BookDeathRecipient(IBinder pServerBinder) {
            mServerBinder = pServerBinder;
        }

        //binderDied方法在客户端Binder线程池执行
        @Override
        public void binderDied() {
            System.out.println("客户端 死亡监听回调");
            System.out.println("客户端 远程注销服务端Binder的死亡监听");
            //注销死亡监听
            mServerBinder.unlinkToDeath(this, 0);
        }
    }
}