package com.design.patterns.rk.Builder;

import com.design.patterns.rk.AbstractFactory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renkai on 2017/3/20.
 */
public class Builder {
    private List<Sender> senders = new ArrayList<Sender>();

    List<Sender> productMailSender(int count){
        for (int i = 0; i < count; i++) {
            senders.add(new MailSender());
        }
        return senders;
    }
    List<Sender> productSmsSender(int count){
        for (int i = 0; i < count; i++) {
            senders.add(new SmsSender());
        }
        return senders;
    }
}
