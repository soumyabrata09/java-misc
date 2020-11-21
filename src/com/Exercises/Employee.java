package com.Exercises;

/*
 * @author Sam
 *
 */
public class Employee {
 private int id;
	public Employee(int id) {
		this.setId(id);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object other ) {
		if(other == null || (other.getClass() != this.getClass()) ) return false;
		if(!(other instanceof Employee)) return false;
		final Employee obj = (Employee) other;
		return this.id == obj.id;
	}
	
}
