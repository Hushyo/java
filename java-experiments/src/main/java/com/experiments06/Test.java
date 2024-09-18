package com.experiments06;
import com.experiments06.entity.*;
import com.experiments06.service.*;
public class Test {
    public static void main(String[] args) {
        Ship ship = new Ship("001", "货船A", 1000.0);
        Container container1 = new Container("C1", 500.0);
        Container container2 = new Container("C2", 600.0);
        Container container3 = new Container("C3",200.0);
        try {
            LoadingService.load(ship, container1,container3,container2);

        } catch (OverWeightException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("货船装载成功，启航");
    }
}