package Test.Thread;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class test {
    public static void main(String[] args){
        sale s=new sale();
        Thread t1=new Thread(s);
        Thread t2=new Thread(s);
        Thread t3=new Thread(s);
        t1.start();
        t2.start();
        t3.start();
        try{
            t1.join();
            t2.join();
            t3.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("结束");
    }
}
