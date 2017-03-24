package com.design.patterns.rk.Visitor;

/**
 * Created by renkai on 2017/3/24.
 */
public class Client {
    public static void main(String[] args) {
        MyVisitor myVisitor = new MyVisitor();
        MySubject mySubject = new MySubject();
        mySubject.accep(myVisitor);
    }
}
