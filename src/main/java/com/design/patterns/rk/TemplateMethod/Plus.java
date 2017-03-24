package com.design.patterns.rk.TemplateMethod;

/**
 * Created by renkai on 2017/3/24.
 */
public class Plus extends AbstractCalculate{
    String getOpt() {
        return "\\+";
    }

    int calculate(int exp1, int exp2) {
        return exp1 + exp2;
    }
}
