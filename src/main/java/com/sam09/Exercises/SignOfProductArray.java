/**
 * Given an integer array arr[] of size N. Let P is the product of all elements in the array. Return 1 if P is positive, 0 if P is equal to 0, and -1 if P is negative.
 *
 * Examples:
 *
 * Input: arr[] = [-1, -2, -3, -4, 3, 2, 1]
 * Output: 1
 * Explanation: The product of all elements in the array is 144 which is positive.
 *
 *
 *
 * Input: arr[] = [1, 9, 0, 5, -7]
 * Output: 0
 * Explanation: The product of all elements in the array is 0.
 */
package com.sam09.Exercises;

import com.sam09.misc.utils.ArrayUtility;

import java.util.Scanner;

public class SignOfProductArray {

    static int getSign(int[] arr) {
        int flag = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return 0;
            }
            if (arr[i] < 0) {
                flag = -flag;
            }
        }

        return flag;
    }

    static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter range of array: \t");
        var range = scanner.nextInt();
        var arr = ArrayUtility.createArray(scanner, range);
        var sign = SignOfProductArray.getSign(arr);
        if (sign > 0) {
            System.out.print("Sign of the product is +ve: " + sign);
        } else if (sign < 0) {
            System.out.print("Sign of the product is -ve: " + sign);
        } else {
            System.out.print("No sign: " + sign);
        }
    }
}
