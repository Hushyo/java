package com.example05Inheritance;

public class Animal implements  Movable{
    private String name;
    public Animal (String name){
        this.name = name;
    }
    @Override
    public void move(){
        System.out.println(name+"moving");
    }

}
