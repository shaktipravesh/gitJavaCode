package com.java.theory.enums;

public enum DayEnum {
    SUNDAY("Sunday", "RaviWar"),
    MONDAY("Monday", "SomWar"),
    TUESDAY("Tuesday", "MangalWar"),
    WEDNESDAY ("Wednesday", "BuddhWar"),
    THURSDAY("Thursday", "GuruWar"),
    FRIDAY("Friday", "ShukraWar"),
    SATURDAY("Saturday", "ShaniWar");

    public String getLower() {
        return lower;
    }

    private final String lower;

    public String getHindi() {
        return hindi;
    }

    private final String hindi;

    DayEnum(String lower, String Hindi) {
        System.out.println("DayEnum Constructor is called");
        this.lower = lower;
        this.hindi = Hindi;
    }

    public void display() {
        System.out.println("Today is " + this.name());
    }
}
