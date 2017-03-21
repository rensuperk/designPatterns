package com.design.patterns.rk.Decorator;

/**
 * Created by renkai on 2017/3/21.
 */
public class Decorator implements Source{
    private Source originalSource;

    public Decorator(Source originalSource) {
        super();
        this.originalSource = originalSource;
    }

    public void method() {
        System.out.println("before method");
        originalSource.method();
        System.out.println("after method");
    }
}
