package com.sam09.Exercises;

import com.sam09.misc.utils.ArrayUtility;

import java.util.Scanner;

/**
 * @author Soumyabrata09
 * For a given array find the largest summation of the consecutive sub-array
 * Sample Input: array of integer {-2, -3, 4, -1, -2, 1, 5, -3}
 * Output will be 7 [ eg: {4,-1,-2,1,5}]
 *
 * Minimum Sum of sub-array
 * Input : arr[] = {3, -4, 2, -3, -1, 7, -5} | 3 -4 2 -3 -1 7 -5
 * Output : -6
 * Subarray is {-4, 2, -3, -1} = -6
 *
 * Input : arr = {2, 6, 8, 1, 4} | 2 6 8 1 4
 * Output : 1
 */
public class LargestSumOfConsecutiveSubArray {

    public int getMaximumSummationOfSubArrays(int[] array) {
        int summation =0;
        int maximumValue = 0;

        for (int i = 0; i < array.length; i++) {
            summation = array[i];
            for (int j = i+1; j < array.length; j++) {
                summation += array[j];
                if ( summation > maximumValue) {
                    maximumValue = summation;
                }
            }
        }

        return maximumValue;
    }

    public int getMinimumSummationOfSubArrays(int[] array) {
        int summation;
        int minimumValue = Integer.MAX_VALUE;

//        2 6 8 1 4
//        3 -4 2 -3 -1 7 -5
        for (int i=0; i< array.length; i++) {
            summation = array[i];
            for (int j=i+1; j< array.length; j++) {
//                summation += array[j];
                int jth = array[j];
                int innerSum = Math.addExact(summation, array[j]);
                summation = ( minimumValue < innerSum ) ? summation : Math.addExact(summation, array[j]);
                if (summation < minimumValue) {
                    minimumValue = summation;
                }
                else {
                    break;
                }
            }
        }

        return minimumValue;
    }

    public static void main(String args[]) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter range of the array: ");
        int range = scanner.nextInt();
        System.out.println("Enter space separated array values: ");
        int[] generatedArray = ArrayUtility.createArray(scanner, range);
        boolean isNotNull = ArrayUtility.hasArrayInitialized(generatedArray);
        if (isNotNull) {
            LargestSumOfConsecutiveSubArray instance = new LargestSumOfConsecutiveSubArray();
            System.out.println("Maximum sum of the sub-array: " + instance.getMaximumSummationOfSubArrays(generatedArray));

            System.out.println("Minimum sum of the sub-array: " + instance.getMinimumSummationOfSubArrays(generatedArray));
        }
        else {
            throw new RuntimeException("Arrays has not been initialized properly");
        }
    }
}
