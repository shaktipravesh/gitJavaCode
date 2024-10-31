package com.java.solid.liskov.substitution;

import java.util.ArrayList;
import java.util.List;

public class LiskovSubstitution {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car());
        vehicleList.add(new MoterCycle());
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getNumberOfWheels());
            System.out.println(vehicle.hasEngine());
        }

        //Now create a Cycle Class
        vehicleList.add(new BiCycle());
        vehicleList.forEach(vehicle -> System.out.println(vehicle.getNumberOfWheels() + ", " + vehicle.hasEngine()));
    }
}
