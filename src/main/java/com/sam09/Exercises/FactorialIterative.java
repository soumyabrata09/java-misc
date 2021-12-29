package com.sam09.Exercises;

import java.util.Scanner;

public class FactorialIterative {

    public static void main(String[] sAmPrD) {
        Scanner ob = new Scanner(System.in);
        System.out.print("Enter a number= ");
        int n = ob.nextInt();
		FactorialIterative obj = new FactorialIterative();
        obj.factCal(n);
    }

    public void factCal(int x) {
        int sum = 1;
        for (int i = 1; i <= x; i++) {
            sum *= i;
        }
        System.out.print(sum);
    }

}
