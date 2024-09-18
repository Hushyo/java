package com.example02;

public class Dish {
    double salt;
    /*
    public static void pri(){
        System.out.println(salt);//静态方法 无法访问 实例级成员
    }
    public static void pri(){
        System.out.println(this.salt);//静态方法 无法访问 实例级成员
    }*/
    static int count = 0;
    static double sumSalt = 0;
    Dish(double salt){
        this.salt = salt;
        count++;
        sumSalt += salt;
    }
}
