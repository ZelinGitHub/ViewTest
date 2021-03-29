package com.fuck.viewtest.menu.concurent.rxjava2.observer;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;

public class ConsumerTest {
    public static void testConsumer1() {
        //目标
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                //发布事件
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });
        Consumer consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("fuck："+integer);
            }
        };
        observable.subscribe(consumer);

    }

  public static void testConsumer2() {
        //目标
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                //发布事件
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });


        observable.subscribe(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {


            }
        });


        observable.subscribe(new Consumer() {
            @Override
            public void accept(Object o) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        }, new Action() {
            @Override
            public void run() throws Exception {

            }
        }, new Consumer<Disposable>() {
            @Override
            public void accept(Disposable disposable) throws Exception {

            }
        });
    }

    public static void testBiConsumer1(){
        //目标
        Observable observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {

                //发布事件
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });
        BiConsumer biConsumer=new BiConsumer<Integer,Boolean>(){


            @Override
            public void accept(Integer integer, Boolean aBoolean) throws Exception {
                System.out.println("fuck："+integer+"// bitch："+aBoolean);

            }
        };


    }
}
