package com.design.patterns.rk.Interpreter;

/**
 * Created by renkai on 2017/3/22.
 */
public class Min implements Expression {
    public int interpreter(Context context) {
        return context.getNum1()-context.getNum2();
    }
}
