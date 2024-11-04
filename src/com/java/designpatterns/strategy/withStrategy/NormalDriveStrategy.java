package com.java.designpatterns.strategy.withStrategy;

public class NormalDriveStrategy implements DriveStrategy{
    public void drive() {
        System.out.println("Normal Drive Strategy");
    }
}
