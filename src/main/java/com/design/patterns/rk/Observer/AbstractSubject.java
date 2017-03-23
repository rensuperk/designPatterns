package com.design.patterns.rk.Observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by renkai on 2017/3/23.
 */
public abstract class AbstractSubject implements  Subject {
    private Vector<Observer> vector = new Vector<Observer>();
    public void add(Observer observer) {
        vector.add(observer);
    }

    public void del(Observer observer) {
        vector.remove(observer);
    }

    public void notifyObserver() {
        Enumeration<Observer> elements = vector.elements();
        while (elements.hasMoreElements()){
            elements.nextElement().update();
        }
    }

}
