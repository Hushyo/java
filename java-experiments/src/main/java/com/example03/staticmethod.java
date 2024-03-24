package com.example03;

public class Main {
    public static void main(String[] args){
        Test.staticprint();// 静态方法直接调用
        //Test.nonstaticprint 是不可以调用的,编译器会建议把			  nonstaticprint前加static,改成静态方法
        Test test = new Test();//非静态方法需要先创建对象
        test.nonstaticprint();//然后借助对象调用
        test.staticprint();//对象当然可以调用静态方法
    }
}