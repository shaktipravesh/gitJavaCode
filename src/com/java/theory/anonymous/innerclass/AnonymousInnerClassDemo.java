package com.java.theory.anonymous.innerclass;

public class AnonymousInnerClassDemo {
	public static void main(String[] args) {
		Employee employee1 = new SoftwareEngineer();
		System.out.println(employee1.getName());
		
		
		//Anonymous Inner class
		Employee employee = new Employee() {
			
			@Override
			public int getSalary() {
				// TODO Auto-generated method stub
				return 50;
			}
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return "Suhasini";
			}
		};
		System.out.println(employee.getName());
		
	}
	
}
