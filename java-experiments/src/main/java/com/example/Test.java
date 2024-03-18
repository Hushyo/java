package com.example;

import com.jogamp.opengl.FPSCounter;

public class Test {
    public static void main(String[] args){
        test(1897,2010);
        summation();
    }
    private static void test(int startYear, int endYear){
        for(int i = startYear; i <= endYear; i++){
            if(i % 400 == 0 || (i % 4 ==0 && i % 100 != 0)){
                System.out.println(i);
            }
        }
    }
    private static void summation(){
        int repeat = 4;
        double n = 3;
        int resultNumber = 0;
        int currentNumber = 0;
        for( int i = 0; i<repeat; i++){
            currentNumber += n*Math.pow(10,i);
            resultNumber += currentNumber;
        }
        System.out.println(resultNumber);
    }

}
