package com.experiments06;

public class OverWeightException extends Exception {
    private String shipId;
    private String shipName;
    private double overWeight;

    public OverWeightException(String shipId, String shipName, double overWeight) {
        super( shipName + " ID: " + shipId + " 超重 " + overWeight + " 公斤");
        this.shipId = shipId;
        this.shipName = shipName;
        this.overWeight = overWeight;
    }
}
