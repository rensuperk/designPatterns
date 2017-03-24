package com.design.patterns.rk.Strategy;

/**
 * Created by renkai on 2017/3/24.
 */
public abstract class AbstractCalculate {

    int[] split(String exp,String opt){
        String[] split = exp.split(opt);
        int[] ints = new int[2];
        ints[0] = Integer.parseInt(split[0]);
        ints[1] = Integer.parseInt(split[1]);
    return ints;
    }
}
