package com.design.patterns.rk.Iterator;

/**
 * Created by renkai on 2017/3/22.
 */
public interface Iterator {
    Object next();
    boolean hasNext();
    Object previous();
    Object first();
}
