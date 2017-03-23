package com.design.patterns.rk.Iterator;

/**
 * Created by renkai on 2017/3/22.
 */
public interface Collection {
    Iterator iterator();
    Object get(int i);
    int size();
}
