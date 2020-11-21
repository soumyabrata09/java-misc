package com.Exercises;

import java.util.Scanner;

/**
 * @author Sam
 *
 */
public class PyramidPattern {
	/*
	 * Input : n = 4
	Output :
	1
	3*2
	4*5*6
	10*9*8*7

	Input : n = 5
	Output :
	1
	3*2
	4*5*6
	10*9*8*7
	11*12*13*14*15
	 * */
	public static void main(String[] args) {
		Scanner ob = new Scanner(System.in);
		System.out.println("Enter range =" );
		int n = ob.nextInt();
		int k =0,j;
		for(int i=1 ; i<=n ;i++) {
			//decide whether the row is even or odd
			if( i%2 != 0) { //odd
				for( j = k+1 ; j< k+i ; j++) {
					System.out.print(j+"*");
				}
				System.out.println(j++);
			//update the value of k
				k =j;
			}
			else { //even
				k = i + k -1;
				for( j = k; j>k-i+ 1 ; j--) {
					System.out.print(j+"*");
				}
				System.out.println(j);
			}
		}
		
	}

}
