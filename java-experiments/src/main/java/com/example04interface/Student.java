package com.example04interface;

public class Student  {
    private String name;
    private Learnable learnable;
    public Student(String name){
        this.name = name;
    }
    public void setLearnable(Learnable learnable){
        this.learnable = learnable;
    }
    public Learnable getLearnable(){
        return learnable;
    }
}
