package com.example04interface;

public abstract class Organism {
    private String name;
    public Organism(String name){
        this.name = name;
    }
    public abstract void move();
}
