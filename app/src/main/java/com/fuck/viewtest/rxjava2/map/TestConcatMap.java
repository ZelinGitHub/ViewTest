package com.fuck.viewtest.rxjava2.map;

import android.util.Log;

import com.fuck.viewtest.rxjava2.bean.Person;
import com.fuck.viewtest.rxjava2.bean.Plan;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class TestConcatMap {

    public static void testConcatMap(){
        List<Person> personList = new ArrayList<Person>();

        Observable.fromIterable(personList)
                .flatMap(new Function<Person, ObservableSource<Plan>>() {
                    @Override
                    public ObservableSource < Plan > apply(Person person) {
                        if ("chan".equals(person.getName())) {
                            return Observable.fromIterable(person.getPlanList()).delay(10, TimeUnit.MILLISECONDS);
                        }
                        return Observable.fromIterable(person.getPlanList());
                    }
                })
                .subscribe(new Observer<Plan>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Plan plan) {
                        Log.d("fuck", "==================plan " + plan.getContent());
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
