package com.design.patterns.rk.AbstractFactory;

/**
 * Created by renkai on 2017/3/20.
 */
public abstract class Client {
    public static void main(String[] args) {
        Sender mailSender = new SendMailFactory().product();
        Sender smsSender = new SendSmsFactory().product();
        mailSender.send();
        smsSender.send();
    }
}
