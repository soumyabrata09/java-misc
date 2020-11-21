/*
 * Given a natural number n (where 1≤n≤9), find the sum of the series having n number of numbers such that the series is n,nn,nnn,…nnn…n times.
 Hence, the required sum is
 n+nn+nnn+⋯+nnn…n
 Constraints
 1≤n≤9
 Input Format
 Integer value of n
 Output Format
 Print the sum of series for n
 Sample Input 1
 2
 Sample Output 1
 24
  
 # 2 + 22
 Sample Input 2
 3
 Sample Output 2
 369
  
 # 3 + 33 + 333 
 Sample Input 3
 4
 Sample Output 3
 4936
 
# 4 + 44 + 444 + 4444

 * 
 */
package com.Exercises;

import java.util.Scanner;

/**
 * @author soumyabrata
 *
 */
public class SumOfSeries {

	/**
	 * @param args for command line argument
	 */
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Integer value of n : ");
		int value = scanner.nextInt();
		int summation =0;
		String interimSeries = "";
		
		if(value >0 && value <10) {
			for(int i =1; i<=value; i++) {
				interimSeries = interimSeries + String.valueOf(value); // converting int > String
				summation = summation + Integer.parseInt(interimSeries); //add it back converting String > int again
			}
			System.out.println("Output : " + summation);
		}
		else {
			System.out.println("Constraints should be followed as \r\n" +
					" 1≤n≤9 ");
		}
	}

}
