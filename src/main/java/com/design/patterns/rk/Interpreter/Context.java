package com.design.patterns.rk.Interpreter;

/**
 * Created by renkai on 2017/3/22.
 */
public class Context {
    private int num1;
    private int num2;

    public Context(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public Context setNum1(int num1) {
        this.num1 = num1;
        return this;
    }

    public int getNum2() {
        return num2;
    }

    public Context setNum2(int num2) {
        this.num2 = num2;
        return this;
    }
}
