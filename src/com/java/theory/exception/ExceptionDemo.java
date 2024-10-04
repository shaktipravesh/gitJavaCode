package com.java.theory.exception;

public class ExceptionDemo {

	public static void main(String[] args) {
		for(int a = 0; a < 100; a++) { 
			System.out.println(Math.floor( (Math.random()*10)));
		}
		int[] numerators = {10, 200, 30, 40};
		int[] denominators = {1, 2, 0, 4};
		for(int i = 0; i < 10; i++) {
			try {
				System.out.println(devideNum(numerators[i], denominators[i]));
			} catch(ArithmeticException e) {
				System.out.println(e);
			} catch (Exception e) {
				StackTraceElement[] stackTraceElements = e.getStackTrace();
				for(int j = 0; j < stackTraceElements.length; j++) {
					System.out.println(stackTraceElements[j]);
				}
				e.printStackTrace();
			}
		}

		StudentEception student = new StudentEception();
		System.out.println(student);
	}

	private static int devideNum(int i, int j) {
		try {
			return i / j;
		} catch (ArithmeticException e) {
			System.out.println(e);
			return -1;
		} catch (Exception e) {
			System.out.println(e);
		}
		return -1;
	}

}


class StudentEception {
	int age = 19;
	String name = "Shakti Pravesh";
	
	@Override
	public String toString() {
		return "Student [age=" + age + ", name=" + name + "]";
	}
}