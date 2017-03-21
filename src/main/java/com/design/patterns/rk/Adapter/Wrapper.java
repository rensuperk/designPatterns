package com.design.patterns.rk.Adapter;

/**
 * Created by renkai on 2017/3/21.
 */
public class Wrapper implements Target{
    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    public void method1() {
        source.method1();
    }

    public void method2() {
        System.out.println("this is method2");
    }
}
