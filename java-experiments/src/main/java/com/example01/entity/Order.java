package com.example01.entity;

public class Order {
    private Item[] items;
    private User user;
    private double sumPrice;

    public Order(User user, Item[] items, double sumPrice){
        this.user = user;
        this.items = items;
        this.sumPrice = sumPrice;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(double sumPrice) {
        this.sumPrice = sumPrice;
    }
}
