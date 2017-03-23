package com.design.patterns.rk.Observer;

/**
 * Created by renkai on 2017/3/23.
 */
public interface Subject {
    void add(Observer observer);
    void del(Observer observer);
    void notifyObserver();
    void operator();
}
