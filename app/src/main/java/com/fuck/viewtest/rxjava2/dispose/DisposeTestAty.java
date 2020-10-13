package com.fuck.viewtest.rxjava2.dispose;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.fuck.viewtest.R;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DisposeTestAty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispose_test);
        initView();
        initUI();
    }

    private void initView() {

    }

    private void initUI() {
        getData();
    }

    private void getData() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                Thread.sleep(5000);
                e.onNext(1);
                e.onComplete();
            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(
                        //观察者
                        new Observer<Integer>() {

                            @Override
                            public void onSubscribe(Disposable d) {
                            }

                            //响应事件
                            @Override
                            public void onNext(Integer integer) {
                                Toast.makeText(DisposeTestAty.this, integer.toString(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onComplete() {
                                Toast.makeText(DisposeTestAty.this, "RxJava完成", Toast.LENGTH_SHORT).show();
                            }
                        });
    }

}
