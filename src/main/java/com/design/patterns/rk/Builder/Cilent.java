package com.design.patterns.rk.Builder;

import java.util.List;

/**
 * Created by renkai on 2017/3/20.
 */
public class Cilent {
    public static void main(String[] args) {

        Builder builder = new Builder();
        List<Sender> senders = builder.productMailSender(3);
        for (Sender sender : senders) {
            sender.send();
        }

    }
}
