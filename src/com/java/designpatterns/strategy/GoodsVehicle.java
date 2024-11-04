package com.java.designpatterns.strategy;

import com.java.designpatterns.strategy.withStrategy.DriveStrategy;
import com.java.designpatterns.strategy.withStrategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }

    @Override
    public void drive() {
        System.out.println("Driving goods vehicle");
    }
}
