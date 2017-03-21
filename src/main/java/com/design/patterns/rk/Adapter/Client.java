package com.design.patterns.rk.Adapter;

/**
 * Created by renkai on 2017/3/21.
 */
public class Client {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.method2();
        adapter.method1();
        Wrapper wrapper = new Wrapper(new Source());
        wrapper.method1();
        wrapper.method2();

        Wrapper1sub1 wrapper1sub1 = new Wrapper1sub1();
        wrapper1sub1.method2();
        wrapper1sub1.method1();

    }
}
