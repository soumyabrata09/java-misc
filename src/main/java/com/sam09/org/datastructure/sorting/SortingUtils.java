package com.sam09.org.datastructure.sorting;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/**
 * This is a utility class which can be invoked when sorting needed
 * @author soumyabratasen
 */
@UtilityClass
public class SortingUtils {

    /**
     * This is the sort method which takes an integer[] array along with the strategy type, i.e MERGE/SELECTION/INSERTION/HEAP etc.
     * @param arr an integer array
     * @param sortingStrategy the strategy type, i.e MERGE/SELECTION/INSERTION/HEAP etc.
     */
    public void sort(int[] arr, SortingStrategy sortingStrategy) {
        switch (sortingStrategy) {
            case HEAP -> new HeapSort().sort(arr);
            case MERGE, SELECTION, INSERTION, QUICK, BUBBLE -> throw new UnsupportedOperationException(String.format("%s sorting has not been implemented", sortingStrategy.name()));
            default -> throw new UnsupportedOperationException(String.format("%s is an unsupported sorting strategy", sortingStrategy.name()));
        }
    }

    /**
     * This is a utility method to print the array values after sorting
     * @param arr a sorted array of integers
     */
    public void print(int[] arr) {
        IntStream.of(arr).forEach(itr -> System.out.print(itr + "\t"));
    }
}
