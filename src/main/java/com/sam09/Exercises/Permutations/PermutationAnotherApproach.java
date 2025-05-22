package com.sam09.Exercises.Permutations;

import java.util.Scanner;

public class PermutationAnotherApproach {
    public static void permute(String input, String output) {
        if (input.length() == 0) {
            System.out.print(output + ", ");
            return;
        }

        for (int index = 0; index < input.length(); index++) {
            char characterAtIndex = input.charAt(index);
            String leftSubsString = input.substring(0, index);
            String rightSubsString = input.substring(index + 1);
            String restString = leftSubsString + rightSubsString;
            /*call permute(String,String) recursively*/
            permute(restString, output + characterAtIndex);
        }
    }

    public static int factorial(int length) {
        if (length == 0) {
            return 1;
        }

        return length * factorial(length - 1);
    }

    public static void main (String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String input = scanner.nextLine();
        System.out.printf("\nTotal number of combination of %s:  %d \n", input, PermutationAnotherApproach.factorial(input.length()));
        PermutationAnotherApproach.permute(input, "");
    }
}
