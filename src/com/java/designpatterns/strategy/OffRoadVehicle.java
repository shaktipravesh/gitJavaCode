package com.java.designpatterns.strategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        System.out.println("Off Road Vehicle");
    }

    @Override
    public void drive() {
        System.out.println("Sports driving Vehicle");
    }
}
