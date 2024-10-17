package com.java.theory.generics;

import java.util.ArrayList;

public class GenericsDemo {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("Shakti Pravesh");
		list.add(30);
		list.add(3.14);
		
		String str = (String) list.get(0);
		String integer = (String) list.get(1);
		
		
		ArrayList<String> listGenerics = new ArrayList<>();
		listGenerics.add("Shakti Pravesh");
		//listGenerics.add(30); it will not allow to add the integer
		//listGenerics.add(3.14);

		NormalClass box = new NormalClass();
		box.setValue(15);
		String strBoxValue = (String) box.getValue();
		System.out.println((String)box.getValue());
		
		GenericsClass<Integer> boxGenerics = new GenericsClass<>();  // this is now type safe
		boxGenerics.setValue(32);
		//String strBoxGenValue = (String) boxGenerics.getValue();  // error will be provided at the compile time
		Integer intBoxGenValue = boxGenerics.getValue();
		
		//GenericsBoundedClass<String> genericsBounded = new GenericsBoundedClass();  // this is now show error because it it bounded to Numbers
		GenericsBoundedClass<Number> genericsBounded = new GenericsBoundedClass(); 
		genericsBounded.setValue(32);
		Number strBoxGenValue = (Number) genericsBounded.getValue();  

		
		
		PairParamGenerics<String, String> pairParamGenerics = new PairParamGenerics<String, String>("Shakti", "Pravesh");
		System.out.println(pairParamGenerics.getKey() +  ": " + pairParamGenerics.getValue());
	}

}
