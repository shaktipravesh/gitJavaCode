package com.java.designpatterns.behavioral.strategy;

import com.java.designpatterns.behavioral.strategy.withStrategy.DriveStrategy;
import com.java.designpatterns.behavioral.strategy.withStrategy.NormalDriveStrategy;
import com.java.designpatterns.behavioral.strategy.withStrategy.SportsDriveStrategy;

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
