package com.example;
public class Student {
    public enum Gender{
        MALE,FEMALE
    }
    private String name;
    private Gender sex;

    public Student(String name, Gender sex) {

        this.name = name;
        this.sex = sex;

    }
    public static void main(String[] args){
        Student maleStudent = new Student("Lily", Student.Gender.MALE);
        Student femaleStudent = new Student ("Peter", Student.Gender.FEMALE);
    }
    // 省略getter/setter
}