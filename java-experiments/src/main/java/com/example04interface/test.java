package com.example04interface;

public class test {
   public static void main(String[] args){
       Organism org = new Organism("kidney"){
           @Override
           public void move(){
               System.out.println("move");
           }
       };
       org.move();






       /*Student s1 = new Student("s1");
       s1.setLearnable(new Learnable(){
           @Override
           public void read(){
               System.out.println("read by s1");
           }
       });
       Student s2 = new Student("s2");
       s2.setLearnable(new Learnable() {
           @Override
           public void read() {
               System.out.println("read by s2");
           }
       });
               s1.getLearnable().read();
               s2.getLearnable().read();*/
   }
}
