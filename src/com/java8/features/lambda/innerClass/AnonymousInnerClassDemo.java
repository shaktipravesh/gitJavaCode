package com.java8.features.lambda.innerClass;


interface Employee {
	int getSalary();
}

public class AnonymousInnerClassDemo {

	static int a = 50;
	public static void main(String[] args) {
		helloEmployee();

	}

	private static void helloEmployee() {
		//int a = 50; // this will be automatically final, you cann't change it, for the same make is instance variable
		Employee employee = () -> {
				a = 67; // this will be automatically final // this is local variable because this is in the method
				System.out.println(a);
				return 75;
			};
		System.out.println(employee.getSalary());
		
		
		Employee employeeInner = new Employee() {
			int x = 43; // this is intance variable because this is a class.
			@Override
			public int getSalary() {
				System.out.println(this.x);
				return 54;
			}
		};
		
	}
}
