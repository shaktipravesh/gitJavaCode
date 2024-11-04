package com.java.designpatterns.strategy;

import com.java.designpatterns.strategy.withStrategy.DriveStrategy;
import com.java.designpatterns.strategy.withStrategy.NormalDriveStrategy;
import com.java.designpatterns.strategy.withStrategy.SportsDriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategy;

    Vehicle(SportsDriveStrategy driveStrategy) {
        this.driveStrategy = (DriveStrategy) driveStrategy;
    }

    public Vehicle(NormalDriveStrategy normalDriveStrategy) {
        this.driveStrategy = (DriveStrategy) normalDriveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
