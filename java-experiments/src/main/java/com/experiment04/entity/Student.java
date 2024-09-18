package com.experiment04.entity;

public class Student {
    public enum Sex{
        MALE,FEMALE
    }
    private int id;
    private String name;
    private Sex sex;

    public Student(int id, String name, Sex sex) {
        this.id = id;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString(){
        return (id+" "+name+" "+sex);
    }

    //getter/setter↓
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

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }
}
