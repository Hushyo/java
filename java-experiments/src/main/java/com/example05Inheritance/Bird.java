package com.example05Inheritance;

public class Bird extends Animal implements Flyable {
    private String color;
    @Override
    public void fly(){
        System.out.println("fly");
    }
   public Bird(String name,String color){
        super(name);
        this.color = color;
   }
}
