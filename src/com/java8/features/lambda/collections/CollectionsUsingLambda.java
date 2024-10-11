package com.java8.features.lambda.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Student 
{ 
    int rollno; 
    String name; 

    @Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + "]";
	}

	// Constructor 
    public Student(int rollno, String name) 
    { 
        this.rollno = rollno; 
        this.name = name; 
    } 

    
} 

class MySort implements Comparator<Student>{

	@Override
	public int compare(Student a, Student b) {
		return b.rollno-a.rollno;
	}
	
}
public class CollectionsUsingLambda {

	public static void main(String[] args) {
	       ArrayList<Student> ar = new ArrayList<Student>(); 
	        ar.add(new Student(111, "bbbab")); 
	        ar.add(new Student(141, "aaaaa")); 
	        ar.add(new Student(121, "cccac")); 

	        System.out.println("Unsorted"); 
	        for (int i=0; i<ar.size(); i++) 
	            System.out.println(ar.get(i)); 

	        Collections.sort(ar, (a, b) -> a.rollno-b.rollno); 

	        System.out.println("\nSorted by rollno"); 
	        for (int i=0; i<ar.size(); i++) 
	            System.out.println(ar.get(i)); 
	        
	        
	       // Collections.sort(ar, (o1, o2) -> );
	        
	        Set<Integer> set = new TreeSet<Integer>();
	        set.add(22);
	        set.add(43);
	        set.add(41);
	        System.out.println("Before sorting: " + set);
	        
	        Set<Integer> setSort = new TreeSet<Integer>((a, b)-> b-a);
	        setSort.add(22);
	        setSort.add(43);
	        setSort.add(41);
	        
	        System.out.println("After sorting: " + setSort);
	        
	        Set<String> setName = new TreeSet<String>();
	        setName.add("Shakti");
	        setName.add("Beena");
	        setName.add("Pravesh");
	        System.out.println("Before sorting: " + setName);
	        
	        Set<String> setSortName = new TreeSet<String>(Collections.reverseOrder());
	        setSortName.add("Shakti");
	        setSortName.add("Beena");
	        setSortName.add("Pravesh");
	        
	        System.out.println("After sorting: " + setSortName);
	        
	        

	}

}
