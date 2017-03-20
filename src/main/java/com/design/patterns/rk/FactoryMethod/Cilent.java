package com.design.patterns.rk.FactoryMethod;

/**
 * Created by renkai on 2017/3/20.
 */
public class Cilent {
    public static void main(String[] args) {

       Sender mailSender = StaticFactoryMethod.mailSenderFactory();
        Sender smsSender = StaticFactoryMethod.smsSenderFactory();
        mailSender.send();
        smsSender.send();

    }
}
