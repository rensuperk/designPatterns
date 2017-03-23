package com.design.patterns.rk.Iterator;

/**
 * Created by renkai on 2017/3/22.
 */
public class MyCollection implements Collection {
    private String[] strings = {"A","B","C","D","E","F"};

    public Iterator iterator() {
        return new MyIterator(this);
    }

    public Object get(int i) {
        return strings[i];
    }

    public int size() {
        return strings.length;
    }
}
