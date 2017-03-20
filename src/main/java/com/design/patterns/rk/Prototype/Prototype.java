package com.design.patterns.rk.Prototype;

import java.io.*;

/**
 * Created by renkai on 2017/3/20.
 */
public class Prototype implements Cloneable,Serializable{
    private static final long serialVersionUID = 1L;
    private String string;
    private SerializableObject serializableObject;

    public Object clone() throws CloneNotSupportedException {
        return (Prototype)super.clone();
    }
    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return objectInputStream.readObject();
    }

    public String getString() {
        return string;
    }

    public Prototype setString(String string) {
        this.string = string;
        return this;
    }

    public SerializableObject getSerializableObject() {
        return serializableObject;
    }

    public Prototype setSerializableObject(SerializableObject serializableObject) {
        this.serializableObject = serializableObject;
        return this;
    }
}
