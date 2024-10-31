package com.java.designpatterns.strategy;

public class PassengerVehicle extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Passenger driving");
    }
}
