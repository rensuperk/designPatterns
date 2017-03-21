package com.design.patterns.rk.Adapter;

/**
 * Created by renkai on 2017/3/21.
 */
public class Adapter extends Source implements Target{
    public void method2() {
        System.out.println("this is method2");
    }
}
