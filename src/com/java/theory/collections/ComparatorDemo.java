package com.java.theory.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student {
	int age;
	String Name;
	public Student(int age, String name) {
		this.age = age;
		Name = name;
	}
	
	public String toString() {
		return "Student [age=" + age + ", Name=" + Name + "]";
	}	
}

public class ComparatorDemo {

	public static void main(String[] args) {
		
		Comparator<Student> comparator = (Student a, Student b)->{
			return a.age > b.age? 1:-1;
		};
		
		Comparator<Integer> comparatorInteger = new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if(a%10 > b%10) {
					return 1;
				}
				return -1;
			}
		};
		
		List<Integer> nums = new ArrayList<Integer>();
		nums.add(63);
		nums.add(45);
		nums.add(86);
		nums.add(42);
		Collections.sort(nums, comparatorInteger);
		
		System.out.println(nums);
		
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(42, "Shakti"));
		students.add(new Student(43, "Beena"));
		students.add(new Student(8, "Suhasini"));
		Collections.sort(students, comparator);
		students.forEach(s->System.out.println(s));
		//System.out.println(students);
	}
	


}
