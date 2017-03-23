package com.design.patterns.rk.State;

/**
 * Created by renkai on 2017/3/23.
 */
public class State {
    private String value;

    public String getValue() {
        return value;
    }

    public State setValue(String value) {
        this.value = value;
        return this;
    }
    void method1(){
        System.out.println("method1");
    }
    void method2(){
        System.out.println("method2");
    }
}
