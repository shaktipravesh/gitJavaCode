package com.java8.features.datentime;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateDemo {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);

		LocalDate myDate = LocalDate.of(1990, 2, 7);
		System.out.println(myDate);
		
		int dayOfMonth = localDate.getDayOfMonth();
		Month month = localDate.getMonth();
		int monthValue = localDate.getMonthValue();
		System.out.println(dayOfMonth);
		System.out.println(month);
		System.out.println(monthValue);
		
		LocalDate yesterday = localDate.minusDays(1);
		System.out.println(yesterday);
		
		System.out.println(localDate.isLeapYear());
		
		

	}

}
