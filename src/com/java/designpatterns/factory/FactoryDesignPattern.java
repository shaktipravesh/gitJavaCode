package com.java.designpatterns.factory;

abstract class Vehicle {
	public abstract void printVehicle();
}

class TwoWheeler extends Vehicle {

	@Override
	public
	void printVehicle() {
		System.out.println("I am two wheeler");
	}
	
	public void vehicleStand() {
		System.out.println("I have two stands");
	}
}

class FourWheeler extends Vehicle {

	@Override
	public
	void printVehicle() {
		System.out.println("I am Four wheeler");
	}
	
	public void vehicleBreak() {
		System.out.println("I have two types of beaks");
	}
}

class Client {
	int wheelCount;
	private Vehicle vehicle;
	
	public Vehicle getVehicle() {
		return vehicle;
	}
	public Client(int wheelCount) {
		this.wheelCount = wheelCount;
		if(wheelCount == 2) {
			vehicle = new TwoWheeler();
		} else if(wheelCount == 4) {
			vehicle = new FourWheeler();
		}
	}
}

public class FactoryDesignPattern {

	public static void main(String[] args) {
		Client client = new Client(2);
		Vehicle clientVehicle  = client.getVehicle();
		clientVehicle.printVehicle();
		Vehicle fourWheeler = new FourWheeler();
		fourWheeler.printVehicle();
		
		FourWheeler car = new FourWheeler();
		car.vehicleBreak();
	}

}
