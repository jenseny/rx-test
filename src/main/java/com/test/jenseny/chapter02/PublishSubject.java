package com.test.jenseny.chapter02;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;

/**
 * Created by riven on 4/28/17.
 */

public class PublishSubject {

    public static void main(String[] args) {
        final rx.subjects.PublishSubject<String> publishSubject = rx.subjects.PublishSubject.create();
        publishSubject.subscribe(new Observer<String>() {
            public void onCompleted() {
                System.out.println("completed");
            }

            public void onError(Throwable throwable) {

            }

            public void onNext(String s) {
                System.out.println("res:"+s);

            }
        });

        Observable.create(new Observable.OnSubscribe<Integer>() {
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onCompleted();

            }
        }).doOnCompleted(new Action0() {
            public void call() {
                publishSubject.onNext("over");
            }
        }).subscribe();
    }
}
