package com.design.patterns.rk.AbstractFactory;

/**
 * Created by renkai on 2017/3/20.
 */
public class MailSender implements Sender {
    public void send() {
        System.out.println("this is a mailSender!");
    }
}
