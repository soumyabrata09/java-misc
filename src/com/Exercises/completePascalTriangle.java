/*
 * Given an integer n the number of rows in a * triangle, write a program to get the triangle with n rows.
         *
        * *
       *   *
      *     *
     *       *
    *         *
   *           *
  *             *
 *               *
 *****************
 
Constraints
n > 2
Input Format
Enter the number of rows in the * triangle: Integer value of n
Output Format
Triangle of n rows with *
Sample Input
10
Sample Output
         *
        * *
       *   *
      *     *
     *       *
    *         *
   *           *
  *             *
 *               *
 *****************

 * 
 */
package com.Exercises;

import java.util.Scanner;

/**
 * @author soumyabrata
 *
 */
public class completePascalTriangle {

	/**
	 * @param args for command line argument
	 */
	public static void main(String[] args)  {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of rows in the * triangle: ");
		int rows = scanner.nextInt();
		
		if(!(rows > 2)) {
			System.out.println("Rows must be > 2");
		}
		else {
			for(int i =0; i< rows; i++ ) {
				for(int initSpace =rows; initSpace >i; initSpace-- ) {
					System.out.print(" ");
				}
				for(int j=0; j<=i ; j++) {
					if(i == (rows-1) || j==i || j==0) { // only print * when starting or ending has reached
						System.out.print("* ");
					}
					else {
						System.out.print("  "); // Double Space 
					}
				}
				System.out.println();
			}
		}
	}

}
