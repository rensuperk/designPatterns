package com.design.patterns.rk.Memento;

/**
 * Created by renkai on 2017/3/22.
 */
public class Original {
    private String value;

    public String getValue() {
        return value;
    }

    public Original setValue(String value) {
        this.value = value;
        return this;
    }

    public Original(String value) {

        this.value = value;
    }
    Memento createMento(){
        return new Memento(this.value);
    }
    void restoreMemnto(Memento memento){
        this.value = memento.getValue();
    }
}
