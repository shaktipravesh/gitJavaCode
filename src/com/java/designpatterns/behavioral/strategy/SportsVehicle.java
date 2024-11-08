package com.java.designpatterns.behavioral.strategy;

import com.java.designpatterns.behavioral.strategy.withStrategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }

    @Override
    public void drive() {
        System.out.println("Sports driving Vehicle");
    }
}
