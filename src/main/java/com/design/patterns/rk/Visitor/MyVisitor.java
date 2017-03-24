package com.design.patterns.rk.Visitor;

/**
 * Created by renkai on 2017/3/24.
 */
public class MyVisitor implements Visitor {
    public void visit(Subject subject) {
        System.out.println("this is"+subject.getSub());
    }
}
