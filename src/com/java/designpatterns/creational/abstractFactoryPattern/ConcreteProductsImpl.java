package com.java.designpatterns.creational.abstractFactoryPattern;

public class ConcreteProductsImpl {
}

class CarWheel implements Wheel {

    @Override
    public void createWheel() {
        System.out.println("CarWheel created");
    }
}

class CarEngine implements Engine {

    @Override
    public void createEngine() {
        System.out.println("CarEngine created");
    }
}

class CarSeat implements Seat {

    @Override
    public void createSeat() {

    }
}

class TruckWheel implements Wheel {

    @Override
    public void createWheel() {
        System.out.println("TruckWheel created");
    }
}

class TruckEngine implements Engine {

    @Override
    public void createEngine() {
        System.out.println("TruckEngine created");
    }
}

class TruckSeat implements Seat {

    @Override
    public void createSeat() {
        System.out.println("TruckSeat created");
    }
}