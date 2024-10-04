package com.java8.features.datentime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class DateTimeDemo {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		localDate = LocalDate.of(1981, 11, 15);
		System.out.println(localDate);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
		LocalTime localTimeOf = LocalTime.of(20, 20, 20, 9990);
		System.out.println(localTimeOf);
		
		LocalTime localTimeZoneId = LocalTime.now(ZoneId.of("America/Cuiaba"));
		System.out.println(localTimeZoneId);
		
		System.out.println(ZoneId.getAvailableZoneIds());

	}

}
