package com.design.patterns.rk.Prototype;

import java.io.IOException;

/**
 * Created by renkai on 2017/3/20.
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Student stu1,stu2,stu3;
        stu1 = new Student("张无忌","男",24,"软件","信息工程学院","南京财经大学");

        // 使用原型
        stu2 = stu1.clone();
        stu2.setStuName("杨过");

        stu3 = stu1.deepClone();
//        stu3.setStuName("小龙女");
//        stu3.setStuSex("女");

        System.out.print("姓名:" + stu1.getStuName());
        System.out.print(",性别:" + stu1.getStuSex());
        System.out.print(",年龄:" + stu1.getStuAge());
        System.out.print(",专业:" + stu1.getStuMajor());
        System.out.print(",学院:" + stu1.getStuCollege());
        System.out.print(",大学:" + stu1.getStuUniversity());
        System.out.println();


        System.out.print("姓名:" + stu2.getStuName());
        System.out.print(",性别:" + stu2.getStuSex());
        System.out.print(",年龄:" + stu2.getStuAge());
        System.out.print(",专业:" + stu2.getStuMajor());
        System.out.print(",学院:" + stu2.getStuCollege());
        System.out.print(",大学:" + stu2.getStuUniversity());
        System.out.println();

        System.out.print("姓名:" + stu3.getStuName());
        System.out.print(",性别:" + stu3.getStuSex());
        System.out.print(",年龄:" + stu3.getStuAge());
        System.out.print(",专业:" + stu3.getStuMajor());
        System.out.print(",学院:" + stu3.getStuCollege());
        System.out.print(",大学:" + stu3.getStuUniversity());
        System.out.println();
        System.out.println(stu1);
        System.out.println(stu2);
        System.out.println(stu3);
        System.out.println(stu1.getGroup() == stu2.getGroup());
        System.out.println(stu1.getGroup() == stu3.getGroup());
    }

}
