package com.design.patterns.rk.TemplateMethod;

/**
 * Created by renkai on 2017/3/24.
 */
public class Client {
    public static void main(String[] args) {
        Plus plus = new Plus();
        int calculate = plus.calculate("2+8");
        System.out.println(calculate);
    }
}
