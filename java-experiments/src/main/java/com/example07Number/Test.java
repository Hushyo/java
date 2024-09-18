package com.example07Number;

import java.math.BigDecimal;
import java.util.Random;

public class Test {
    public static void main(String[] args){
     float f1 = 0.2F;
     float f2 = 0.1F;
     System.out.println(f1+f2);
     BigDecimal b1 = new BigDecimal("0.2");
     BigDecimal b2 = new BigDecimal("0.1");
     float f3 = b1.add(b2).floatValue();
     System.out.println(f3);
    }
}
