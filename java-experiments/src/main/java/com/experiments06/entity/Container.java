package com.experiments06.entity;

public class Container {
    private String id;
    private double weight;

    public Container(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }
    public double getWeight() {
        return weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
