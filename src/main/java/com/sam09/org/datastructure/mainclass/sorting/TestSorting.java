package com.sam09.org.datastructure.mainclass.sorting;

import com.sam09.org.datastructure.sorting.OrderBy;
import com.sam09.org.datastructure.sorting.SortingStrategy;
import com.sam09.org.datastructure.sorting.SortingUtils;

import java.util.Scanner;
import java.util.stream.IntStream;

public class TestSorting {

    static int[] takeInput() {
        var scanner = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        var size = scanner.nextInt();
        System.out.println("Enter array values:\t");
        var arr = new int[size];
        IntStream.range(0, size)
                .forEach(i -> arr[i] = scanner.nextInt());

        scanner.close();
        return arr;
    }

    public static void main(String args[]) {
        /*var arr = takeInput();
        System.out.print("Sorted Array:\n");
        SortingUtils.sort(arr, SortingStrategy.HEAP);
        SortingUtils.print(arr);*/
        System.out.println("=====");
        var arr = takeInput();
        System.out.println("Sorted Array (Asc):");
        SortingUtils.sort(arr, SortingStrategy.SELECTION, OrderBy.ASC);
        SortingUtils.print(arr);
        System.out.println("\n=====");
        System.out.println("Sorted Array (Desc):");
        SortingUtils.sort(arr, SortingStrategy.SELECTION, OrderBy.DESC);
        SortingUtils.print(arr);
    }
}
