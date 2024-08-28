package com.java.theory.abstractclass;

public class AbstractDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new MyUpdatedCar();
		car.drive();
		car.playMusic();;
		car.fly();
	}

}


abstract class Car {
	public abstract void drive();
	public abstract void fly();
	
	public void playMusic() {
		System.out.println("Playing music");
	}
}

abstract class myAnotherCar extends Car {

	@Override
	public void fly() {
		System.out.println("I am flying");
	}
	
}

abstract class MyCar extends Car {

	@Override
	public void drive() {
		System.out.println("Car driving.");
		
	}
}

class MyUpdatedCar extends MyCar {

	@Override
	public void fly() {
		System.out.println("My Updated car flying");
		
	}
}
