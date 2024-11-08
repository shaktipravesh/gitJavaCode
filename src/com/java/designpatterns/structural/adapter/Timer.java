package com.java.designpatterns.structural.adapter;

public class Timer {
    Mobile mobile;

    public Mobile getMobile() {
        return mobile;
    }

    public void setMobile(Mobile mobile) {
        this.mobile = mobile;
    }

    public void displayTimer(String time) {
        mobile.display(time);
    }
}
