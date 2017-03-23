package com.design.patterns.rk.Memento;

/**
 * Created by renkai on 2017/3/22.
 */
public class Client {
    public static void main(String[] args) {
        Original a = new Original("a");
        System.out.println(a.getValue());
        Storge storge = new Storge(a.createMento());
        a.setValue("b");

        System.out.println(a.getValue());
        a.restoreMemnto(storge.getMemento());
        System.out.println(a.getValue());
    }
}
