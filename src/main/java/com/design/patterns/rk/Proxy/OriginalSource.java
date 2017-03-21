package com.design.patterns.rk.Proxy;

/**
 * Created by renkai on 2017/3/21.
 */
public class OriginalSource implements Source {
    public void method() {
        System.out.println("this is original method");
    }
}
