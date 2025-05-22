package com.sam09.Exercises;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author sam
 *
 */
public class TestPrivateConstructor {

	public static void main(String[] args) {
		try {
			Constructor<ObjectCreation_Of_Private_Constructor> instance = ObjectCreation_Of_Private_Constructor.class.getDeclaredConstructor();
			try {
				ObjectCreation_Of_Private_Constructor obj = instance.newInstance();
				obj.setName("Hi Soumya");
				System.out.println("------------");
				obj.getName();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
