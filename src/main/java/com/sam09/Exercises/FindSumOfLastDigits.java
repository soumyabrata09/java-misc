package com.sam09.Exercises;

import com.sam09.misc.utils.ArrayUtility;

import java.util.Scanner;

/**
 * @author Soumyabrata09
 */
public class FindSumOfLastDigits {

    private static int getSumOfLastDigits(int range, int[] array) {
        int result = -404;
        int sum = 0;
        for (int index =0; index< range; index++) {
            int[] arrayElement = Integer.toString(array[index])
                    .chars()
                    .map( element -> element - '0')
                    .toArray();

            sum += arrayElement[arrayElement.length - 1];
        }
        result = sum;

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the range");
        int range = scanner.nextInt();
        System.out.println("Enter space-separated values: ");
        int[] generatedArray = ArrayUtility.createArray(scanner, range);
        boolean isNotNull = ArrayUtility.hasArrayInitialized(generatedArray);
        if (isNotNull) {
            System.out.println("Sum of Last digits: " + getSumOfLastDigits(range, generatedArray));
        }
        else {
            throw new RuntimeException("Arrays has not been initialized properly");
        }
    }
}
