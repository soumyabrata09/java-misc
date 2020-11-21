package com.Exercises;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// Using Constructor class we can create object of the private constructor
public class ObjectCreation_Of_Private_Constructor {

	private String name;
	private ObjectCreation_Of_Private_Constructor() {
		// TODO Auto-generated constructor stub
	}

	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public static void main(String[] args) {
		try {
			Constructor<ObjectCreation_Of_Private_Constructor> obj
			= ObjectCreation_Of_Private_Constructor.class.getDeclaredConstructor();
			
			ObjectCreation_Of_Private_Constructor o1= obj.newInstance();
			o1.setName("Object created from a private constructor");
			System.out.println( o1.getName());
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
