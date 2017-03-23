package com.design.patterns.rk.Iterator;

/**
 * Created by renkai on 2017/3/22.
 */
public class Client {
    public static void main(String[] args) {
        MyCollection myCollection = new MyCollection();
        Iterator iterator = myCollection.iterator();
        System.out.println(iterator.first());
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }
    }
}
