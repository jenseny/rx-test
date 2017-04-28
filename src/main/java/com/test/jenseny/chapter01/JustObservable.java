package com.test.jenseny.chapter01;

import rx.Observable;
import rx.Observer;

/**
 * Created by riven on 4/28/17.
 */
public class JustObservable {

    private static String hello(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
    public static void main(String[] args) {
        Observable<String> observable = Observable.just(hello());
        observable.subscribe(new Observer<String>() {
            public void onCompleted() {
                System.out.println("completed");
            }

            public void onError(Throwable throwable) {

            }

            public void onNext(String s) {
                System.out.println("res:"+s);

            }
        });
    }
}
