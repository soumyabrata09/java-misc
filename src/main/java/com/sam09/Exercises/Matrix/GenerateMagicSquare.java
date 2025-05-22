/**
 * 
 */
package com.sam09.Exercises.Matrix;

import java.util.Scanner;

import com.sam09.Exercises.Matrix.Resources.MagicSquare;

/**
 * @author Sam
 *
 */
public class GenerateMagicSquare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)){ //using try with resource(s);This helps automatic resources clean up ,therefore no need
			//have a separate finally block 
		System.out.println("Enter a number to create a magic square matrix -> ");
		Integer number = scanner.nextInt();
		
		MagicSquare instance = new MagicSquare();
		
		System.out.println("Magic Constant of the ["+number+"x"+"] is :: "+ instance.GetMagicConstant(number));
		
		System.out.println(" ::Magic Square :: ");
		instance.DisplayMagicSquare(MagicSquare.getMagicSquare(number) , number);
	}
	}

}
