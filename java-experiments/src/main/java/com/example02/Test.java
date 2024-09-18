package com.example02;

public class Test {
    public static void main(String[] args) {
        Dish d1 = new Dish(0.1);
        Dish d2 = new Dish(0.4);
        Dish d3 = new Dish(0.5);
        System.out.println("一共做了" + Dish.count + "盘菜");
        System.out.println("一共用了" + Dish.sumSalt + "g盐");
        System.out.println("一共用了" + d3.sumSalt + "g盐");
    }
}
