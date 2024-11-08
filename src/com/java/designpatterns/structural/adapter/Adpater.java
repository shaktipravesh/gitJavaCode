package com.java.designpatterns.structural.adapter;

public class Adpater implements Mobile{
    Charger charger = new Charger();
    @Override
    public void display(String name) {
        charger.charge("It's charging from adapter");
    }
}
