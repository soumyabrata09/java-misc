package com.sam09.Exercises;

/**
 * @author Soumyabrata09
 * For a given array find the largest summation of the consecutive sub-array
 * Sample Input: array of integer {-2, -3, 4, -1, -2, 1, 5, -3}
 * Output will be 7 [ eg: {4,-1,-2,1,5}]
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

    public static void main(String args[]) {
        int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};

        LargestSumOfConsecutiveSubArray instance = new LargestSumOfConsecutiveSubArray();
        System.out.println("Maximum sum of the sub-array: " + instance.getMaximumSummationOfSubArrays(a));
    }
}
