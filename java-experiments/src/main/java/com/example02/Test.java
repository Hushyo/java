package com.example02;

public class Test {
    public static void main(String[] args){
        Bicycle bicycle = new Bicycle();
        bicycle.setGear(5);
        test(bicycle);
        System.out.println("离开方法后："+bicycle.getGear());
    }
    private static void test(Bicycle bicycle){
        System.out.println("方法修改前："+bicycle.getGear());
        bicycle.setGear(2);
        System.out.println("方法修改后:"+bicycle.getGear());
    }
}
