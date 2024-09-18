package com.experiments06.entity;
import com.experiments06.OverWeightException;
public class Ship {
    private String id;
    private String name;
    private double maxWeight;
    private double currentWeight = 0.0;

    public Ship(String id, String name, double maxWeight) {
        this.id = id;
        this.name = name;
        this.maxWeight = maxWeight;
    }

    public void load(Container container) throws OverWeightException {
        double newWeight = currentWeight + container.getWeight();
        if (newWeight > maxWeight) {
            throw new OverWeightException(id, name, newWeight - maxWeight);
        }
        currentWeight = newWeight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }
}
