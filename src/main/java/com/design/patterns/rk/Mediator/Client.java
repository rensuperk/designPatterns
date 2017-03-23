package com.design.patterns.rk.Mediator;

/**
 * Created by renkai on 2017/3/22.
 */
public class Client {
    public static void main(String[] args) {
        MyMediator myMediator = new MyMediator();
        myMediator.createMedia();
        myMediator.work();
    }
}
