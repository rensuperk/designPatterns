package com.design.patterns.rk.Proxy;

/**
 * Created by renkai on 2017/3/21.
 */
public class Proxy implements Source{
    private Source source;

    public Proxy() {
        this.source = new OriginalSource();
    }
    void before(){
        System.out.println("this is before");
    }
    void after(){
        System.out.println("this is after");
    }
    public void method() {
        before();
        source.method();
        after();
    }
}
