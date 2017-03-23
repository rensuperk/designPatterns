package com.design.patterns.rk.Observer;

/**
 * Created by renkai on 2017/3/23.
 */
public class MySubject extends AbstractSubject {
    public void operator() {
        System.out.println("update self");
        notifyObserver();
    }
}
