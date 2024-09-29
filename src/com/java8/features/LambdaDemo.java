package com.java8.features;

interface A {
	void show(int i);
}

/*
class xyz implements A {

	public void show() {
		System.out.println("xyz Hello");
		
	}
	
}
*/

public class LambdaDemo {

	public static void main(String[] args) {
		/*
		 * A obj; obj = new xyz(); obj.show();
		 */

		/*
		A obj;
		obj = new A() {
			
			public void show() {
				System.out.println("Lamda Demo A");
				
			}
		};
		obj.show();
		*/
		
		A obj1 = i ->System.out.println("Lamda Demo Arrow " + i);
		obj1.show(4);
	}

}
