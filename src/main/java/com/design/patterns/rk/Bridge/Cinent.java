package com.design.patterns.rk.Bridge;

/**
 * Created by renkai on 2017/3/21.
 */
public class Cinent {
    public static void main(String[] args) {
        Mybridge mybridge = new Mybridge();
        Sourcesub1 sourcesub1 = new Sourcesub1();
        Sourcesub2 sourcesub2 = new Sourcesub2();
        mybridge.setSource(sourcesub1);
        mybridge.method1();
        mybridge.setSource(sourcesub2);
        mybridge.method1();

    }
}
