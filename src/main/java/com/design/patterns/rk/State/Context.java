package com.design.patterns.rk.State;

/**
 * Created by renkai on 2017/3/23.
 */
public class Context {
    private State state;

    public State getState() {
        return state;
    }

    public Context setState(State state) {
        this.state = state;
        return this;
    }

    public Context(State state) {

        this.state = state;
    }
    public void method(){
        if(state.getValue().equals("method1")){
            state.method1();
        }
        if(state.getValue().equals("method2")){
            state.method2();
        }
    }
}
