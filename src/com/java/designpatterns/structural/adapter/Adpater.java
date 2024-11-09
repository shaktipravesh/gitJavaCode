package com.java.designpatterns.structural.adapter;

public class Adpater implements Mobile{
    Charger charger = new Charger();
    @Override
    public void display(String name) {
        System.out.println("Displaying from adapter: " + name);
        charger.charge("It's charging from adapter");
    }
}
