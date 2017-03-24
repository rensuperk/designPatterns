package com.design.patterns.rk.Visitor;

/**
 * Created by renkai on 2017/3/24.
 */
public class MySubject implements Subject{
    public void accep(Visitor visitor) {
        visitor.visit(this);
    }

    public String getSub() {
        return "love";
    }
}
