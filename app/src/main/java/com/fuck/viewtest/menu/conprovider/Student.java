package com.fuck.viewtest.menu.conprovider;

public class Student {
    private final static String TAG = "Student";

    public Integer id;
    public String name;
    public Integer gender;
    public String number;
    public Integer score;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", number='" + number + '\'' +
                ", score=" + score +
                '}';
    }
}
