package com.design.patterns.rk.Command;

/**
 * Created by renkai on 2017/3/22.
 */
public class MyCommand implements Command {

    private Receiver receiver;

    public MyCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public MyCommand setReceiver(Receiver receiver) {
        this.receiver = receiver;
        return this;
    }

    public void exe() {
        receiver.action();
    }
}
