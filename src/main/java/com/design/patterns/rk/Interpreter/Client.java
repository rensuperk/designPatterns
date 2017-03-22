package com.design.patterns.rk.Interpreter;

/**
 * Created by renkai on 2017/3/22.
 */
public class Client {
    public static void main(String[] args) {
        int interpreter = new Min().interpreter(new Context(new Plus().interpreter(new Context(1, 2)), 1));
        System.out.println("min.interpreter = " + interpreter);
    }
}
