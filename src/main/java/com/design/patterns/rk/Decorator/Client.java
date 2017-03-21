package com.design.patterns.rk.Decorator;

/**
 * Created by renkai on 2017/3/21.
 */
public class Client {
    public static void main(String[] args) {
        Decorator decorator = new Decorator(new OriginalSource());
        decorator.method();
    }
}
