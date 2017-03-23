package com.design.patterns.rk.Memento;

/**
 * Created by renkai on 2017/3/22.
 */
public class Storge {
    private Memento memento;

    public Storge(Memento memento) {
        this.memento = memento;
    }

    public Memento getMemento() {
        return memento;
    }

    public Storge setMemento(Memento memento) {
        this.memento = memento;
        return this;
    }
}
