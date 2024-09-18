package com.example01.Service;
import com.example01.entity.*;

public class OrderService {
    public static Order addOrder(User user,Item[] items) {
        double sumPrice = 0;
        for(int i = 0; i < items.length; i++){
            sumPrice += items[i].getNum()*items[i].getProduct().getPrice();
        }
        if(user.getBalance() > sumPrice ){
            Order order = new Order(user, items, sumPrice);
            return order;
        }
        else return null;
    }
}
/**
 * 实现addOrder()业务方法，实现创建订单的业务逻辑
 * 传入购买的用户，以及本次购买的全部购买项
 * 当用户余额大于购买商品总花费时，创建订单，封装购买用户/购买项/总花费，并返回订单对象
 * 当余额小于总花费时，返回空引用
 * 参数类型及返回类型
 */