package com.experiments07;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        RailwayDepartment railwayDepartment = new RailwayDepartment();
        TicketOffice office1 = new TicketOffice("售票点1", railwayDepartment);
        TicketOffice office2 = new TicketOffice("售票点2", railwayDepartment);
        TicketOffice office3 = new TicketOffice("售票点3", railwayDepartment);
        Thread t1 = new Thread(office1);
        Thread t2 = new Thread(office2);
        Thread t3 = new Thread(office3);
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
        System.out.println("售票点1销售数: " + office1.getSales());
        System.out.println("售票点2销售数: " + office2.getSales());
        System.out.println("售票点3销售数: " + office3.getSales());
        System.out.println("实际车票总数: " + (office1.getSales() + office2.getSales() + office3.getSales()));
    }
}