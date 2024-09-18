package com.experiments06.service;
import com.experiments06.entity.*;
import com.experiments06.OverWeightException;

public class LoadingService {
    public static void load(Ship ship, Container... containers) throws OverWeightException {
        for (Container container : containers) {
            ship.load(container);
        }
    }
}