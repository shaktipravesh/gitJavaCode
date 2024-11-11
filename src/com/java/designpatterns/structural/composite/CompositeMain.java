package com.java.designpatterns.structural.composite;

public class CompositeMain {
    public static void main(String[] args) {
        ComputerComponent hd = new Leaf(4000, "HardDrive");
        ComputerComponent mouse = new Leaf(300, "Monitor");
        ComputerComponent keyboard = new Leaf(700, "KeyBoard");
        ComputerComponent cpu = new Leaf(2000, "CPU");
        ComputerComponent ram = new Leaf(1300, "RAM");

        Composite peri = new Composite("Peri");
        Composite cabinet = new Composite("Cabinet");
        Composite motherBoard = new Composite("MotherBoard");
        Composite computer = new Composite("Computer");

        motherBoard.addComputerComponent(cpu);
        motherBoard.addComputerComponent(ram);
        motherBoard.addComputerComponent(hd);

        peri.addComputerComponent(motherBoard);
        peri.addComputerComponent(mouse);
        peri.addComputerComponent(keyboard);

        computer.addComputerComponent(cabinet);
        computer.addComputerComponent(peri);
        ram.displayPrice();

        peri.displayPrice();
    }
}
