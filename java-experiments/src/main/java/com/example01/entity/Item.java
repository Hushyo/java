package com.example01.entity;

public class Item {
    private int num;
    private Product product;

    public Item(Product product, int num){
        this.num = num;
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
