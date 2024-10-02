package com.java.theory.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class CollectionDemo {

	public static void main(String[] args) {
		Collection<Integer> nums = new ArrayList<Integer>();
		nums.add(4);
		nums.add(5);
		nums.add(6);
		nums.add(7);
		System.out.println(nums);
		for(int i : nums) {
			System.out.println(i);
		}
		
		
		Set<Integer> set = new TreeSet<Integer>();
		

		Map<String, Integer> map = new HashMap<String, Integer>();
	}
	
	Comparator<Integer> com = new Comparator<Integer>() {
		
		@Override
		public int compare(Integer o1, Integer o2) {
			if(o1 > o2) {
				return 1;
			}
			return 0;
		}
	};

}
