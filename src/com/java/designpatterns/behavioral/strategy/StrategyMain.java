package com.java.designpatterns.behavioral.strategy;

public class StrategyMain {
    public static void main(String[] args) {
        Vehicle vehicleSports = new SportsVehicle();
        vehicleSports.drive();

        Vehicle vehicleGoods = new GoodsVehicle();


    }
}
