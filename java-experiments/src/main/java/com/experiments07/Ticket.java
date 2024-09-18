package com.experiments07;

class Ticket {
    private int id;
    private String startStation;
    private String endStation;

    public Ticket(int id, String startStation, String endStation) {
        this.id = id;
        this.startStation = startStation;
        this.endStation = endStation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }
}

