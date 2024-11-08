package com.java.designpatterns.behavioral.strategy;

import com.java.designpatterns.behavioral.strategy.withStrategy.NormalDriveStrategy;

public class OffRoadVehicle extends Vehicle {

    OffRoadVehicle() {
        super(new NormalDriveStrategy());
    }

    @Override
    public void drive() {
        System.out.println("Sports driving Vehicle");
    }
}
