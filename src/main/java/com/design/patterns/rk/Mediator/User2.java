package com.design.patterns.rk.Mediator;

/**
 * Created by renkai on 2017/3/22.
 */
public class User2 extends User {
    public User2(Mediator mediator) {
        super(mediator);
    }

    void work() {
        System.out.println("user2 work");
    }
}
