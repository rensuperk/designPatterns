package com.design.patterns.rk.Singleton;

/**
 * Created by renkai on 2017/3/20.
 */
public class Singleton5 {

    private static Singleton5 instance;
    private Singleton5() {
    }

    public Object readResolve(){
        return this;
    }


    private static synchronized void singletonFactory(){
        if (instance == null) {
            instance = new Singleton5();
        }
    }
    public static Singleton5 getInstance(){

        if(instance == null){
            singletonFactory();
        }
        return instance;
    }
}
