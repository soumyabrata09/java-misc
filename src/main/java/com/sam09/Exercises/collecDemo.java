package com.sam09.Exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Sam
 *
 */
public class collecDemo {

	/**
	 * @param args for command line argument
	 */
	public static void main(String[] args) {

		ArrayList<Employee> list = new ArrayList<>();
		Set<Employee> set = new HashSet<>();
		
		Employee e = new Employee(2);
		list.add(e);
		e.setId(3);
		list.add(e);
		System.out.println("list size : "+ list.size() + " and list value " + list.toString()+"\n");
		
		Iterator<Employee> itr = list.iterator();
		System.out.println(" Actual List value after iterating over the collection object<arrayList> : ");
		while(itr.hasNext())
			System.out.println(itr.next());
		
		set.add(e);
		e.setId(4);
		set.add(e);
		itr = set.iterator();
		System.out.println("set size : "+ set.size() + " and set value " + set.toString()+"\n");
		
		System.out.println(" Actual List value after iterating over the collection object<Set> : ");
		while(itr.hasNext())
			System.out.println(itr.next());
	}

}
