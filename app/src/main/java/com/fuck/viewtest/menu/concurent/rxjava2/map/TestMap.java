package com.fuck.viewtest.menu.concurent.rxjava2.map;

import android.util.Log;

import com.fuck.viewtest.menu.concurent.rxjava2.bean.Person;
import com.fuck.viewtest.menu.concurent.rxjava2.bean.Plan;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class TestMap {
    public static void testMap() {
        Observable observable = Observable.just(1, 2, 3)
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "I'm " + integer;
                    }
                });

    }


    public static void testMap2() {

        List<Person> personList = new ArrayList<Person>();

        //准备的发布事件是personList
        Observable observable = Observable.fromIterable(personList)
                //变换，把next事件元素类型Person变换为List<Plan>
                .map(new Function<Person, List<Plan>>() {

                    @Override
                    public List<Plan> apply(Person person) throws Exception {
                        //执行变换的代码

                        return person.getPlanList();
                    }
                });

        observable.subscribe(new Observer<List<Plan>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            //变换后的参数是List < Plan > plans
            @Override
            public void onNext(List<Plan> plans) {
                for (Plan plan : plans) {
                    List<String> planActionList = plan.getStringList();
                    for (String action : planActionList) {
                        Log.d("fuck", "==================action " + action);
                    }
                }
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
