package com.java.designpatterns.strategy;

import com.java.designpatterns.strategy.withStrategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {
    SportsVehicle() {
        super(new SportsDriveStrategy());
    }

    @Override
    public void drive() {
        System.out.println("Sports driving Vehicle");
    }
}
