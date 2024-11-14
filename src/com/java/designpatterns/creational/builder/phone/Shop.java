package com.java.designpatterns.creational.builder.phone;

public class Shop {
	public static void main (String args[]) {
		Phone p = new Phone("Android", 2, "Qualcomm", 5.5, 4500);

		System.out.println(p);
		
		Phone phone = new PhoneBuilder().setBattery(3000).setRam(2).setProcessor("Intel").getPhone();
		System.out.println(phone);

	}

}
