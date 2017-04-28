package com.test.jenseny.chapter01;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Created by riven on 4/28/17.
 */
public class CreateObservable {

    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(new Observable.OnSubscribe<Integer>() {
            public void call(Subscriber<? super Integer> subscriber) {
                for(int i = 0; i< 5;i++){
                    subscriber.onNext(i);
                }
                subscriber.onCompleted();
            }
        });
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
