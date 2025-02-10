package com.java.designpatterns.creational.abstractFactoryPattern;


import static java.lang.System.*;

public class AbstractFactoryExample {
    public static void main(String[] args) {
        //Create a car
        out.println("Car factory");
        VehicleFactory carFactory = new CarFactory();

        Wheel carWheel = carFactory.createWheel();
        Engine carEngine = carFactory.createEngine();
        Seat carSeat = carFactory.createSeat();

        carWheel.createWheel();
        carEngine.createEngine();
        carSeat.createSeat();
        out.println();

        //Create a Truck
        out.println("Truck Factory");
        TruckFactory truckFactory = new TruckFactory();
        Wheel truckWheel = truckFactory.createWheel();
        Engine truckEngine = truckFactory.createEngine();
        Seat truckSeat = truckFactory.createSeat();

        truckWheel.createWheel();
        truckEngine.createEngine();
        truckSeat.createSeat();
        out.println();
    }
}
