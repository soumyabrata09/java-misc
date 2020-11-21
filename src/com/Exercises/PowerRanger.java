/*
 * 
 * Given 3 inputs n, minimum, & maximum, find the number of values raised to the nth power that lie in the range [minimum, maximum], inclusive.
	Constraints:
	1.	Remember that the range is inclusive.
	2.	a < b will always be true.
	Input Format
	Three integer value of n, minimum, maximum
	Output Format
	Print the number of values raised to the nth power that lie in the range minimum & maximum.
	Sample Input 1
	2, 49, 65
	Sample Output 1
	2
	 
	# 2 squares (n^2) lie between 48 and 65, 49 (7^2) and 64 (8^2)
	Sample Input 2
	3, 1, 27
	Sample Output 2
	3
	 
	# 3 cubes (n^3) lie between 1 and 27, 1 (1^3), 8 (2^3) and 27 (3^3)
	Sample Input 3
	10, 1, 5
	Sample Output 3
	1
	 
	# 1 value raised to the 10th power lies between 1 and 5, 1 (1^10)

 * 
 */
package com.Exercises;

import java.util.Scanner;

/**
 * @author soumyabrata
 *
 */
public class PowerRanger {

	/**
	 * @param num expects an integer value: actual input
	 * @param power expects an integer value: actual power input value
	 */
	
	static int calculatePowerRecursively(int num, int power) {
		if(power == 0) {
			return 1;
		}
		else {
			return num*calculatePowerRecursively(num, power-1);
		}
	}
	
	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Provide Three integer value of n, minimum, maximum :\t");
		int number = scanner.nextInt();
		int minimum = scanner.nextInt();
		int maximum = scanner.nextInt();
		int count =0;
		if( !(minimum < maximum) ) {
			System.out.println("Constraint : minimum < maximum should always be true");
		}
		else {
			for(int i =1; i< 20; i++) { //for the time keeping a hard-coded upper boundary : 20[ Keeping such had-coded value is a bad practice]
				int calculatedValue = calculatePowerRecursively(i,number);
				if( calculatedValue >= minimum && calculatedValue <= maximum) {
					count++;
				}
			}
			System.out.println( "Output : " + count );
		}
	}

}
