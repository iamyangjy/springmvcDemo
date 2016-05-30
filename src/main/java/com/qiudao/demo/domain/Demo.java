package com.qiudao.demo.domain;

import com.sun.xml.internal.txw2.output.SaxSerializer;

import java.io.Serializable;

/**
 * Created by hdfs on 2016/5/30.
 */
public class Demo implements Serializable{
    private static final long serialVersionUID = 5067103827813611024L;
    private int id;
    private String name;
    private  int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
