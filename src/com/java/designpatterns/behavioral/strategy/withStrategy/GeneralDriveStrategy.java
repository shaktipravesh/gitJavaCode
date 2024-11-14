package com.java.designpatterns.behavioral.strategy.withStrategy;

public class GeneralDriveStrategy implements DriveStrategy {
    public void drive() {
        System.out.println("General Drive Strategy");
    }
}
