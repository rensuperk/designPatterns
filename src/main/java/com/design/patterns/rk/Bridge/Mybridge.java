package com.design.patterns.rk.Bridge;

/**
 * Created by renkai on 2017/3/21.
 */
public class Mybridge extends Bridge{
    void method1(){
        getSource().method1();
    }
}
