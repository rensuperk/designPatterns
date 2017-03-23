package com.design.patterns.rk.Mediator;

/**
 * Created by renkai on 2017/3/22.
 */
public class MyMediator implements Mediator {
    private User1 user1;
    private User2 user2;
    public void createMedia() {
        user1= new User1(this);
        user2 = new User2(this);
    }

    public void work() {
        user1.work();
        user2.work();
    }
}
