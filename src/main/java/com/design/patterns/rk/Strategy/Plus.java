package com.design.patterns.rk.Strategy;

/**
 * Created by renkai on 2017/3/24.
 */
public class Plus extends AbstractCalculate implements Calculate {
    public int caculate(String exp) {
        int[] split = split(exp, "\\+");

        return split[0] + split[1];
    }
}
