package com.java.designpatterns.strategy;

public class StrategyMain {
    public static void main(String[] args) {
        Vehicle vehicleSports = new SportsVehicle();
        vehicleSports.drive();

        Vehicle vehicleGoods = new GoodsVehicle();


    }
}
