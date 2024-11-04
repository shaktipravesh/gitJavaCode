package com.java.designpatterns.strategy;

import com.java.designpatterns.strategy.withStrategy.NormalDriveStrategy;
import com.java.designpatterns.strategy.withStrategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {

    OffRoadVehicle() {
        super(new NormalDriveStrategy());
    }

    @Override
    public void drive() {
        System.out.println("Sports driving Vehicle");
    }
}
