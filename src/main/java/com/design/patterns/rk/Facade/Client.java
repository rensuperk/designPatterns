package com.design.patterns.rk.Facade;

/**
 * Created by renkai on 2017/3/21.
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startup();
        computer.shutdown();
    }
}
