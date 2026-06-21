package com.sam09.org.datastructure.mainclass.sorting;

import com.sam09.org.datastructure.sorting.OrderBy;
import com.sam09.org.datastructure.sorting.SortingStrategy;
import com.sam09.org.datastructure.sorting.SortingUtils;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TestSorting {

    public static final Scanner SCANNER = new Scanner(System.in);

    static int[] processInput() {
        System.out.println("Enter the size of array: ");
        var size = SCANNER.nextInt();
        System.out.println("Enter array values:\t");
        var arr = new int[size];
        IntStream.range(0, size).forEach(i -> arr[i] = SCANNER.nextInt());

        return arr;
    }

    static void sortByStrategy(SortingStrategy strategy) {
        System.out.println("=====");
        var arr = processInput();
        var arrAsc = Arrays.copyOf(arr, arr.length);
        var arrDesc = Arrays.copyOf(arr, arr.length);

        System.out.printf("Sorted Array (Asc) - Strategy -> %s %n", strategy.name());
        SortingUtils.sort(arrAsc, strategy, OrderBy.ASC);
        SortingUtils.print(arrAsc);
        System.out.println("\n=====");
        System.out.printf("Sorted Array (Desc) - Strategy -> %s%n", strategy.name());
        SortingUtils.sort(arrDesc, strategy, OrderBy.DESC);
        SortingUtils.print(arrDesc);
        System.out.println("\n=====");
    }

    // Sample Arrar: [ 18 6 51 39 4 ], n = 5
    public static void main(String args[]) {
        /*var arr = processInput();
        System.out.print("Sorted Array:\n");
        SortingUtils.sort(arr, SortingStrategy.HEAP);
        SortingUtils.print(arr);*/
        sortByStrategy(SortingStrategy.SELECTION);
        sortByStrategy(SortingStrategy.INSERTION);
        sortByStrategy(SortingStrategy.MERGE);

        SCANNER.close();
    }
}
