package com.design.patterns.rk.Singleton;

/**
 * Created by renkai on 2017/3/20.
 */
public class Singleton3 {
    private static Singleton3 instance;

    private Singleton3() {
    }
    public static synchronized Singleton3 getInstance(){
        if( instance ==null){
            synchronized (instance) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
    public Object readResolve(){
        return instance;
    }

}
