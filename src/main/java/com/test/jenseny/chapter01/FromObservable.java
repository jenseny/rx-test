package com.test.jenseny.chapter01;

import rx.Observable;
import rx.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by riven on 4/28/17.
 */
public class FromObservable {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(5);
        for (int i =0;i<5;i++){
            list.add(i);
        }
        Observable<Integer> observable = Observable.from(list);
        observable.subscribe(new Observer<Integer>() {
            public void onCompleted() {
                System.out.println("completed");
            }

            public void onError(Throwable throwable) {

            }

            public void onNext(Integer integer) {
                System.out.println("item:"+integer);

            }
        });
    }
}
