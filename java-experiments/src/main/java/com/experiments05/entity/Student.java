package com.experiments05.entity;

import com.experiments05.Test;

public class Student {
    private String name;
    private int id;
    private int year;
    private Teacher teacher;

    public Student(String name, int id, int year, Teacher teacher) {
        this.name = name;
        this.id = id;
        this.year = year;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
