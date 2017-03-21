package com.design.patterns.rk.ChainOfResponsebility;

/**
 * Created by renkai on 2017/3/21.
 */
public abstract class AbstractHandler {
    private Handler handler;



    public Handler getHandler() {
        return handler;
    }

    public AbstractHandler setHandler(Handler handler) {
        this.handler = handler;
        return this;
    }
}
