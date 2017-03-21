package com.design.patterns.rk.Bridge;

/**
 * Created by renkai on 2017/3/21.
 */
public abstract class Bridge {
    private Source source;

    void method1(){
        source.method1();
    }
    public Source getSource() {
        return source;
    }

    public Bridge setSource(Source source) {
        this.source = source;
        return this;
    }
}
