package com.design.patterns.rk.Singleton;

/**
 * Created by renkai on 2017/3/20.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }
    public static Singleton getInstance(){
        if( instance ==null){
            instance= new Singleton();
        }
        return instance;
    }
    public Object readResolve(){
        return instance;
    }

}
