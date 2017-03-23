package com.design.patterns.rk.Observer;

/**
 * Created by renkai on 2017/3/23.
 */
public class Client {
    public static void main(String[] args) {
        MySubject mySubject = new MySubject();
        mySubject.add(new Observer1());
        mySubject.add(new Observer2());
        mySubject.operator();

    }
}
