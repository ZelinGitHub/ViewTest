package com.fuck.viewtest.menu.rxjava2.map;

import android.util.Log;

import com.fuck.viewtest.menu.rxjava2.bean.Person;
import com.fuck.viewtest.menu.rxjava2.bean.Plan;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class TestFlatMap {

    public static void testFlatMap() {
        List<Person> personList = new ArrayList<Person>();

        //准备发布的事件是personList
        Observable.fromIterable(personList)
                //平坦变换
                //平坦变换的apply返回的数据类型是Observable
                .flatMap(new Function<Person, ObservableSource<Plan>>() {
                    @Override
                    public ObservableSource<Plan> apply(Person person) {
                        //返回Observable
                        //这个Observable准备发布person.getPlanList()事件
                        //每个next事件的元素是Plan
                        return Observable.fromIterable(person.getPlanList());
                    }
                })
                //平坦变换
                //平坦变换的apply返回的数据类型是Observable
                .flatMap(new Function<Plan, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(Plan plan) throws Exception {
                        //返回Observable
                        //这个Observable准备发布plan.getStringList()事件
                        //每个next事件的元素是String
                        return Observable.fromIterable(plan.getStringList());
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("fuck", "action: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }


    public static void testFlatMapX() {


        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);

            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(final Integer integer) throws Exception {
                return Observable.create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        emitter.onNext(integer + "Str");
                        emitter.onComplete();
                    }
                });
            }
        })

                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("fuck", "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("fuck", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "onComplete");
                    }
                });

    }

    public static void testFlatMapY() {


        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(0);
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
                emitter.onNext(4);

            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(final Integer integer) throws Exception {
                return Observable.just(integer + "Str");
            }
        })

                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.d("fuck", "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("fuck", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "onComplete");
                    }
                });

    }

    public static void testFlatMapZ() {

        System.out.println("testFlatMapZ所在线程："
                + Thread.currentThread().getName());

        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) {
                System.out.println("Observable.create所在线程："
                        + Thread.currentThread().getName());
                emitter.onNext(0);

            }
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final Integer integer) {
                        System.out.println("flatMapOld所在线程："
                                + Thread.currentThread().getName());
                        return Observable.just(integer + "StrOld");
                    }
                })
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final String str) {
                        System.out.println("flatMapNew所在线程："
                                + Thread.currentThread().getName());
                        return Observable.just(str + "StrNew");
                    }
                })

                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println("onNext所在线程："
                                + Thread.currentThread().getName());
                        Log.d("fuck", "onNext: " + s);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("fuck", "onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("fuck", "onComplete");
                    }
                });
    }

    public static void testFlatMapO() {


        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) {
                emitter.onNext(0);

            }
        })
                .flatMap(new Function<Integer, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final Integer integer) {
                        return Observable.just(integer + "StrOld");
                    }
                })
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(final String str) {
                        return Observable.just(str + "StrNew");
                    }
                })

                .subscribeOn(Schedulers.io())
                .doAfterNext(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        System.out.println("==============doAfterNext：" + s);
                    }
                })
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
