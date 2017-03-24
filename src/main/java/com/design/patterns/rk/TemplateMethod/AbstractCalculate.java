package com.design.patterns.rk.TemplateMethod;

/**
 * Created by renkai on 2017/3/24.
 */
public abstract class AbstractCalculate {
    final int calculate(String exp){
        int[] ints = split(exp);
        return calculate(ints[0],ints[1]);
    }
    abstract String getOpt();
    abstract int calculate(int exp1,int exp2);
    int[] split(String exp){
        String[] split = exp.split(getOpt());
        int[] ints = new int[2];
        ints[0] = Integer.parseInt(split[0]);
        ints[1] = Integer.parseInt(split[1]);
    return ints;
    }
}
