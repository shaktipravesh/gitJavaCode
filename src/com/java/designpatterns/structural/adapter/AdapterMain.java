package com.java.designpatterns.structural.adapter;

public class AdapterMain {
    public static void main(String[] args) {
        Mobile mobile = new Adpater();
        Timer timer = new Timer();
        timer.setMobile(mobile);
        timer.displayTimer("This is timer.");
    }
}
