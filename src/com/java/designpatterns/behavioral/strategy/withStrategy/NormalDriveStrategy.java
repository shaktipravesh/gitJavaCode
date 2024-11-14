package com.java.designpatterns.behavioral.strategy.withStrategy;

public class NormalDriveStrategy implements DriveStrategy{
    public void drive() {
        System.out.println("Normal Drive Strategy");
    }
}
