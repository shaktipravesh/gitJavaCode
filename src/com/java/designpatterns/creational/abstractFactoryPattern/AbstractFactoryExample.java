package com.java.designpatterns.creational.abstractFactoryPattern;

public class AbstractFactoryExample {
    public static void main(String[] args) {
        //Create a car
        System.out.println("Car factory");
        VehicleFactory carFactory = new CarFactory();

        Wheel carWheel = carFactory.createWheel();
        Engine carEngine = carFactory.createEngine();
        Seat carSeat = carFactory.createSeat();

        carWheel.createWheel();
        carEngine.createEngine();
        carSeat.createSeat();
        System.out.println();

        //Create a Truck
        System.out.println("Truck Factory");
        TruckFactory truckFactory = new TruckFactory();
        Wheel truckWheel = truckFactory.createWheel();
        Engine truckEngine = truckFactory.createEngine();
        Seat truckSeat = truckFactory.createSeat();

        truckWheel.createWheel();
        truckEngine.createEngine();
        truckSeat.createSeat();
        System.out.println();
    }
}
