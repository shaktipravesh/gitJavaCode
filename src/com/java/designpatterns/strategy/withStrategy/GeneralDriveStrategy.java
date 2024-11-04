package com.java.designpatterns.strategy.withStrategy;

public class GeneralDriveStrategy implements DriveStrategy {
    public void drive() {
        System.out.println("General Drive Strategy");
    }
}
