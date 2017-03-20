package com.design.patterns.rk.Prototype;

import java.io.*;

/**
 * Created by renkai on 2017/3/20.
 */
public class Student implements Cloneable,Serializable{

    private static final long serialVersionUID = 1L;
    private String stuName;
    private String stuSex;
    private int stuAge;
    private String stuMajor;
    private String stuCollege;
    private String stuUniversity;
    private Group group;

    public Group getGroup() {
        return group;
    }

    public Student setGroup(Group group) {
        this.group = group;
        return this;
    }

    public Student(String stuName, String stuSex, int stuAge, String stuMajor, String stuCollege, String stuUniversity) {
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
        this.stuMajor = stuMajor;
        this.stuCollege = stuCollege;
        this.stuUniversity = stuUniversity;
        this.group=new Group();
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
    public Student deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Student) objectInputStream.readObject();
    }
    public String getStuName() {
        return stuName;
    }

    public Student setStuName(String stuName) {
        this.stuName = stuName;
        return this;
    }

    public String getStuSex() {
        return stuSex;
    }

    public Student setStuSex(String stuSex) {
        this.stuSex = stuSex;
        return this;
    }

    public int getStuAge() {
        return stuAge;
    }

    public Student setStuAge(int stuAge) {
        this.stuAge = stuAge;
        return this;
    }

    public String getStuMajor() {
        return stuMajor;
    }

    public Student setStuMajor(String stuMajor) {
        this.stuMajor = stuMajor;
        return this;
    }

    public String getStuCollege() {
        return stuCollege;
    }

    public Student setStuCollege(String stuCollege) {
        this.stuCollege = stuCollege;
        return this;
    }

    public String getStuUniversity() {
        return stuUniversity;
    }

    public Student setStuUniversity(String stuUniversity) {
        this.stuUniversity = stuUniversity;
        return this;
    }
}
