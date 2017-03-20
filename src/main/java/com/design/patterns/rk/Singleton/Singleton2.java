package com.design.patterns.rk.Singleton;

/**
 * Created by renkai on 2017/3/20.
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
    }
    public static synchronized Singleton2 getInstance(){
        if( instance ==null){
            instance= new Singleton2();
        }
        return instance;
    }
    public Object readResolve(){
        return instance;
    }

}
