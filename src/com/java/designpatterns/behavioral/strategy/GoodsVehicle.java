package com.java.designpatterns.behavioral.strategy;

import com.java.designpatterns.behavioral.strategy.withStrategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }

    @Override
    public void drive() {
        System.out.println("Driving goods vehicle");
    }
}
