package com.example01;
import com.example01.entity.*;
import static com.example01.Service.OrderService.addOrder;

public class Test {
    public static void main(String[] args){
        User user = new User("Peter",1000,"SunStreet");

        Item[] items = new Item[2];
        items[0] = new Item(new Product("Elden ring",298),2);
        items[1] = new Item(new Product("Sekiro2",134),3);

        Order order = addOrder(user,items);
        if(order != null){
            System.out.println("商品总额:" + order.getSumPrice());
            System.out.println("用户余额:" + (order.getUser().getBalance()-order.getSumPrice()));
            System.out.println("用户地址:" + order.getUser().getAddress());
        }
        else System.out.println("余额不足");
    }
}
