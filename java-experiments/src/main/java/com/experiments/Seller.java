package com.experiments;

public class Seller extends Employee{
    private double salesCommision;
    private double salesRevenue;

    public Seller(String name,double salary,double salesRevenue,double salesCommision){
        super(name,salary);
        this.salesRevenue = salesRevenue;
        this.salesCommision = salesCommision;
    }

    public double getSalesCommision() {
        return salesCommision;
    }

    public void setSalesCommision(double salesCommision) {
        this.salesCommision = salesCommision;
    }

    public double getSalesRevenue() {
        return salesRevenue;
    }

    public void setSalesRevenue(double salesRevenue) {
        this.salesRevenue = salesRevenue;
    }

    @Override
    public double calculateSalary() {
        return getSalary() + salesRevenue * salesCommision ;
    }
}
