package com.experiments07;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class TicketOffice implements Runnable{

    private String name;
    private List<Ticket> soldTickets;
    private RailwayDepartment railwayDepartment;

    public TicketOffice(String name, RailwayDepartment railwayDepartment) {
        this.name = name;
        this.soldTickets = new ArrayList<>();
        this.railwayDepartment = railwayDepartment;
    }
    @Override
    public void run() {
        for(int i =0 ;i<200;i++){
            Ticket ticket = railwayDepartment.getTicket();
            if (ticket != null) {
                soldTickets.add(ticket);
                try {
                    Thread.sleep(new Random().nextInt(50));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
    }
    public int getSales() {
        return soldTickets.size();
    }
}

