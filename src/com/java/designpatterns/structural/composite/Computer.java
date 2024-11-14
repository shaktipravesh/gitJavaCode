package com.java.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

interface ComputerComponent {
    void displayPrice();
}

class Leaf implements ComputerComponent{
    int price;
    String peripheralName;

    public Leaf(int price, String peripheralName) {
        this.price = price;
        this.peripheralName = peripheralName;
    }

    @Override
    public void displayPrice() {
        System.out.println(peripheralName + ": " + price);
    }
}

class Composite implements ComputerComponent{
    String computerName;
    List<ComputerComponent> components = new ArrayList<>();

    public Composite(String computerName) {
        this.computerName = computerName;
    }

    public void addComputerComponent (ComputerComponent computerComponent) {
        components.add(computerComponent);
    }

    @Override
    public void displayPrice() {
        System.out.println("Computer: " + computerName);
        components.forEach(computerComponent -> computerComponent.displayPrice());
    }
}

public class Computer {
}
