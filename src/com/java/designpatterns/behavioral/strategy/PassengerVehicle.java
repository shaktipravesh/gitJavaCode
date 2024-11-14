package com.java.designpatterns.behavioral.strategy;

import com.java.designpatterns.behavioral.strategy.withStrategy.SportsDriveStrategy;

public class PassengerVehicle extends Vehicle {
    PassengerVehicle() {
        super(new SportsDriveStrategy());
    }

    @Override
    public void drive() {
        System.out.println("Passenger driving");
    }
}
