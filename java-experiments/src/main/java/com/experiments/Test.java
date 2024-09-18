package com.experiments;

public class Test {
    public static void main(String[] args){
        Manager manager = new Manager("经理", 5000, 2);
        Seller seller = new Seller("销售", 3000, 20000, 0.15);
        Workable[] employees = {manager, seller};
        System.out.println("员工工资总额: " + SalaryService.getTotalSalaries(employees));
    }
}
