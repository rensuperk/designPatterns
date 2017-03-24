package com.design.patterns.rk.Strategy;

/**
 * Created by renkai on 2017/3/24.
 */
public class Client {
    public static void main(String[] args) {
        String exp = "2+8";
        Plus plus = new Plus();
        int caculate = plus.caculate(exp);
        System.out.println(caculate);
    }
}
