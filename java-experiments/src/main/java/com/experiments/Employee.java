package com.experiments;

public abstract class Employee implements Workable{
    private String name;
    private double salary;

    public String getName() {
        return name;
    }
    public Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
    }

    @Override
   public void updateName(String name){
        this.name = name;
   }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public double getSalary(){
        return this.salary;
    }

}
