package com.design.patterns.rk.Visitor;

/**
 * Created by renkai on 2017/3/24.
 */
public interface Subject {
    void accep(Visitor visitor);
    String getSub();
}
