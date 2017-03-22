package com.design.patterns.rk.Command;

/**
 * Created by renkai on 2017/3/22.
 */
public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker(new MyCommand(new Receiver()));
        invoker.action();
    }
}
