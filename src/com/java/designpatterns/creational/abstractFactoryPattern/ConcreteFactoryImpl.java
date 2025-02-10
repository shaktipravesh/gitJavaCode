package com.java.designpatterns.creational.abstractFactoryPattern;

public class ConcreteFactoryImpl {
}

class CarFactory implements VehicleFactory {

    @Override
    public Wheel createWheel() {
        return new CarWheel();
    }

    @Override
    public Engine createEngine() {
        return new CarEngine();
    }

    @Override
    public Seat createSeat() {
        return new CarSeat();
    }
}

class TruckFactory implements VehicleFactory {

    @Override
    public Wheel createWheel() {
        return new TruckWheel();
    }

    @Override
    public Engine createEngine() {
        return new TruckEngine();
    }

    @Override
    public Seat createSeat() {
        return new TruckSeat();
    }
}
