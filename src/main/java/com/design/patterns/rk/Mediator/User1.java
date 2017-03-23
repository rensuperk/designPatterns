package com.design.patterns.rk.Mediator;

/**
 * Created by renkai on 2017/3/22.
 */
public class User1 extends User {
    public User1(Mediator mediator) {
        super(mediator);
    }

    void work() {
        System.out.println("user1 work");
    }
}
