package com.experiments;

public class Manager extends Employee{
    private int grade;

    public Manager(String name,double salary,int grade){
        super(name,salary);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    @Override
    public double calculateSalary() {
        return grade * getSalary() * 0.8;
    }
}
