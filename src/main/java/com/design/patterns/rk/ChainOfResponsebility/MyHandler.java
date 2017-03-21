package com.design.patterns.rk.ChainOfResponsebility;

/**
 * Created by renkai on 2017/3/21.
 */
public class MyHandler extends AbstractHandler implements Handler  {
    private String name;

    public MyHandler(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MyHandler setName(String name) {
        this.name = name;
        return this;
    }

    public void operator() {
        System.out.println(name+"deal");
        if(getHandler() != null){
            getHandler().operator();
        }
    }
}
