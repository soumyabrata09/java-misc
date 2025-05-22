package com.sam09.Exercises;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindSumOFConsecutiveArrays {

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,5,7,1,1,1,6};
        final int resultantSum = 3;
        for (int i =0; i< array.length; i++) {
            int sum =0;
            for (int j = i; j< array.length; j++) {
                sum += array[j];
                if (sum == resultantSum) {
                    printArray(array, i, j);
                }
               /* else
                    continue;*/
            }
        }
    }

    public static void printArray(int[] array, int i, int j) {
        List<Integer> resultantArrayList = IntStream.range(i, j+1)
                .mapToObj( arrayIndex -> array[arrayIndex])
                .toList();
        System.out.println(resultantArrayList);
    }
}
