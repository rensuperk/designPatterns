package com.design.patterns.rk.State;

/**
 * Created by renkai on 2017/3/23.
 */
public class Client {
    public static void main(String[] args) {
        State state = new State();
        state.setValue("method1");
        Context context = new Context(state);
        context.method();

    }
}
