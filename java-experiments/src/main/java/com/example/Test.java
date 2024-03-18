package com.example;

import com.jogamp.opengl.FPSCounter;

public class Test {
    public static void main(String[] args){
        test(1897,2010);
    }
    private static void test(int startYear, int endYear){
        for(int i = startYear; i <= endYear; i++){
            if(i % 400 == 0 || (i % 4 ==0 && i % 100 != 0)){
                System.out.println(i);
            }
        }
    }
}
