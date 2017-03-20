package com.design.patterns.rk.Singleton;

/**
 * Created by renkai on 2017/3/20.
 */
public class Singleton4 {

    private Singleton4() {
    }

    public Object readResolve(){
        return this;
    }


    private static class SingletonFactory{
        private static Singleton4 instance = new Singleton4();
    }
    public static Singleton4 getInstance(){
        return SingletonFactory.instance;
    }
}
