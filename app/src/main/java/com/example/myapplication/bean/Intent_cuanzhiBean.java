package com.example.myapplication.bean;

import android.os.Parcelable;

import java.io.Serializable;

public class Intent_cuanzhiBean  implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

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


    @Override
    public String toString() {

        return "Intent_cuanzhiBean{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
