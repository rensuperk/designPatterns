package com.design.patterns.rk.FactoryMethod;

/**
 * Created by renkai on 2017/3/20.
 */
public class StaticFactoryMethod {
    static Sender mailSenderFactory(){
        return new MailSender();
    }
    static Sender smsSenderFactory(){
        return new SmsSender();
    }
}
