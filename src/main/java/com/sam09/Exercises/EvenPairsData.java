package com.sam09.Exercises;

import com.sam09.misc.utils.ArrayUtility;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Soumyabrata09
 * <div>
 *     <p>
 * Given an unsorted array and a number n, find if there exists a pair of elements in the array whose difference is n.
 * Examples:
 *
 *
 * Enter the array range:
 * 6
 * Enter the common difference:
 * 3
 * Enter array elements:
 * 6 5 7 3 1 4
 * Pairs : 1 & 4 having diff 3
 * Pairs : 3 & 6 having diff 3
 * Pairs : 4 & 7 having diff 3
 * </p>
 * </div>
 */
public class EvenPairsData {

    public static void getPairs(int[] array, int difference, int range) {
        Arrays.sort(array);
        for (int index = 0; index < range; index++) {
            /**
             * At a given index position if the (array[index] + difference) gives a positive index value ( i.e how binarySearch() works)
             * then we can conclude that that is the number on the given array having common difference
             */
            int endValue = (Math.abs(difference) + Math.abs(array[index]));
            int searchedIndex = Arrays.binarySearch(array, endValue);
            /**
             * binarySearch will give the index number if a match is found otherwise -4 will be the output
             */
            if (searchedIndex > 0) {
                System.out.println("Pairs : " + array[index] + " & " + array[searchedIndex] + " having difference " + difference);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the array range: ");
        int range = scanner.nextInt();
        System.out.println("Enter the common difference: ");
        int commonDifference = scanner.nextInt();
        System.out.println("Enter array elements: ");
        int[] generatedArray = ArrayUtility.createArray(scanner, range);
        boolean isNotNull = ArrayUtility.hasArrayInitialized(generatedArray);
        if (isNotNull) {
            getPairs(generatedArray, commonDifference, range);
        }
        else {
            throw new RuntimeException("Array has not been initialized properly");
        }
    }
}
