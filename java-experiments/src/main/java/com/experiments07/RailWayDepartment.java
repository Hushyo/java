package com.experiments07;
import java.util.ArrayList;
import java.util.List;

class RailwayDepartment {

    private List<Ticket> tickets;

    public RailwayDepartment() {
        this.tickets = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            tickets.add(new Ticket(i, "哈尔滨", "北京"));
        }
    }

    public synchronized Ticket getTicket() {
        if (tickets.size() > 0) {
            return tickets.remove(0);
        } else {
            return null;
        }
    }
}
