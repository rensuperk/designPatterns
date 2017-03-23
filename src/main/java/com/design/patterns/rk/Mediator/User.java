package com.design.patterns.rk.Mediator;

/**
 * Created by renkai on 2017/3/22.
 */
public abstract class User {
    private Mediator mediator;

    public User(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public User setMediator(Mediator mediator) {
        this.mediator = mediator;
        return this;
    }
    abstract void work();
}
