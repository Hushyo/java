package com.example08String;

public class Test {
    private static void etry() {
        try {
            System.out.println("A");
            System.out.println("B");
            return;
            //System.out.println("C");

        } catch (Exception e) {

            System.out.println("D");
        } finally {
            System.out.println("E");
        }
        System.out.println("F");
        return;
    }
    public static void main(String[] args){
        Test.etry();
    }
}
