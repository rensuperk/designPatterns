package com.design.patterns.rk.Memento;

/**
 * Created by renkai on 2017/3/22.
 */
public class Memento {

    private String value;

    public Memento(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Memento setValue(String value) {
        this.value = value;
        return this;
    }
}
