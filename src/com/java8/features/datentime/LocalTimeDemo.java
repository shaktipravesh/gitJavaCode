package com.java8.features.datentime;
import java.time.LocalTime;

public class LocalTimeDemo {

	public static void main(String[] args) {
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		LocalTime customTime = LocalTime.of(14, 20);
		System.out.println(customTime);
		
		String timeStr = "16:43:59";
		LocalTime stringTimeParse = LocalTime.parse(timeStr);
		System.out.println(stringTimeParse);
		
		LocalTime beforeOneHourTime = localTime.minusHours(2);
		System.out.println(beforeOneHourTime);
		
	}

}
