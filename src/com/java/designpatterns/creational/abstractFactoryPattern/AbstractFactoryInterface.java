package com.java.designpatterns.creational.abstractFactoryPattern;

public class AbstractFactoryInterface {
}

interface VehicleFactory {
    Wheel createWheel();
    Engine createEngine();
    Seat createSeat();
}
