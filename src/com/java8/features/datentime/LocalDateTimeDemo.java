package com.java8.features.datentime;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class LocalDateTimeDemo {

	public static void main(String[] args) {
		LocalDateTime loDateTime = LocalDateTime.now();
		System.out.println(loDateTime);

		ZonedDateTime zoDateTime = ZonedDateTime.now();
		System.out.println(zoDateTime);

	}

}
