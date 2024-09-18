package com.example;

public class Rectangular implements Shape {

    private int height;

    private int width;

    public Rectangular(int height, int width) {

        this.height = height;

        this.width = width;

    }

    @Override
    public int getPerimeter() {
        return height * 2 + width * 2;
    }
    public int getArea() {
        return height * width;
    }

}