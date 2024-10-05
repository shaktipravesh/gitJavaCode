package com.java.theory.enums;

import java.util.Arrays;

public class EnumsDemo {

	public static void main(String[] args) {
//		DayClassMethod();
//		DayInterfaceMethod();
//		DayEnumMethod();

		DayEnum monday = DayEnum.MONDAY;
		int ordinal = monday.ordinal();
		System.out.println(ordinal);

		System.out.println(monday.name());
		DayEnum dayName = DayEnum.valueOf(DayEnum.MONDAY.name());
		System.out.println(dayName);

		DayEnum[] values = DayEnum.values();
		Arrays.stream(values).forEach(System.out::println);

		DayEnum day = DayEnum.valueOf("MONDAY");
		switch (day) {
            case SUNDAY -> {
				System.out.println("Sunday");
            }
            case MONDAY -> {
				System.out.println("Monday");
            }
            case TUESDAY -> {
				System.out.println("Tuesday");
            }
            case WEDNESDAY -> {
				System.out.println("Wednesday");
            }
            case THURSDAY -> {
				System.out.println("Thursday");
            }
            case FRIDAY -> System.out.println("Friday");
            case SATURDAY -> {
				System.out.println("Saturday");
            }
        }

		String today = switch (day) {
			case SUNDAY -> "SUN";
            case MONDAY -> "MON";
            case TUESDAY -> "TUE";
            case WEDNESDAY -> "WED";
            case THURSDAY -> "THU";
            case FRIDAY -> "FRI";
            case SATURDAY -> "SAT";
        };
	}

	private static void DayEnumMethod() {
		System.out.println("DayEnumMethod");
		System.out.println(DayEnum.MONDAY);
		System.out.println(DayEnum.TUESDAY);
		System.out.println(DayEnum.WEDNESDAY);
		System.out.println(DayEnum.THURSDAY);
		System.out.println(DayEnum.FRIDAY);
		System.out.println(DayEnum.SATURDAY);
		System.out.println(DayEnum.SUNDAY);
	}

	private static void DayInterfaceMethod() {
		System.out.println("Day interface Method");
		System.out.println(DayInterface.MONDAY);
		System.out.println(DayInterface.TUESDAY);
		System.out.println(DayInterface.WEDNESDAY);
		System.out.println(DayInterface.THURSDAY);
		System.out.println(DayInterface.FRIDAY);
		System.out.println(DayInterface.SATURDAY);
		System.out.println(DayInterface.SUNDAY);
	}

	private static void DayClassMethod() {
		System.out.println("Day Class Method");
		System.out.println(DayClass.MONDAY);
		System.out.println(DayClass.TUESDAY);
		System.out.println(DayClass.WEDNESDAY);
		System.out.println(DayClass.THURSDAY);
		System.out.println(DayClass.FRIDAY);
		System.out.println(DayClass.SATURDAY);
		System.out.println(DayClass.SUNDAY);
	}


}
