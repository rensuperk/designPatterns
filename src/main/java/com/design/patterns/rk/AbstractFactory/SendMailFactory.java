package com.design.patterns.rk.AbstractFactory;

/**
 * Created by renkai on 2017/3/20.
 */
public class SendMailFactory implements Provider {
    public Sender product() {
        return new MailSender();
    }
}
