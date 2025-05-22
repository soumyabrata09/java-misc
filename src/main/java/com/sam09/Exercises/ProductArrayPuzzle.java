package com.sam09.Exercises;
/**
 * The Product Array Puzzle requires constructing an output array such that each element at index i is the product of all elements in the input array except the one at i. The challenge is to do this efficiently, ideally without using division, and in linear time.
 *
 * Example:
 *
 * Input: [10, 3, 5,[6][2]
 * Output: `[180, 600, 360, 300,tput = 3 * 5 * 6 * 2 = 180
 *
 * Output = 10 * 5 * 6 * 2 = 600
 *
 * ... and so on.
 */

import com.sam09.misc.utils.ArrayUtility;
import java.util.Arrays;
import java.util.Scanner;

public class ProductArrayPuzzle {

    private static void productArrayExceptSelf(int[] generatedArr, int range, int[] product) {
        var prefix = generatePrefixProductArr(range, generatedArr);
        var suffix = generateSuffixProductArr(range, generatedArr);

        for (int i = 0; i < product.length; i++) {
            product[i] = prefix[i] * suffix[i];
        }
        printProductArray(product);
    }

    private static int[] generatePrefixProductArr(int range, int[] array) {
        var prefix = new int[range];
        prefix[0] = 1;
        for (int i = 1; i < range; i++) {
            prefix[i] = prefix[i -1] * array[i -1];
        }
        return prefix;
    }

    private static int[] generateSuffixProductArr(int range, int[] arr) {
        var suffix = new int[range];
        suffix[range -1] = 1;
        for (int i = (range - 2); i>= 0; i --) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }
        return suffix;
    }

    private static void printProductArray(int[] product) {
        System.out.print("Product Array:");
        Arrays.stream(product).forEach(val -> System.out.print(val + " "));
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.print("Enter Array Range: \t");
        var range = scanner.nextInt();
        var generatedArr = ArrayUtility.createArray(scanner, range);
        var product = new int[range];
        ProductArrayPuzzle.productArrayExceptSelf(generatedArr, range, product);
    }
}
