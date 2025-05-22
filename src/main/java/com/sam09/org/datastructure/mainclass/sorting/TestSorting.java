package com.sam09.org.datastructure.mainclass.sorting;

import com.sam09.org.datastructure.sorting.SortingStrategy;
import com.sam09.org.datastructure.sorting.SortingUtils;

import java.util.Scanner;
import java.util.stream.IntStream;

public class TestSorting {

    void main() {
        var scanner = new Scanner(System.in);
        System.out.print("Enter the desired size of the array: ");
        var size = scanner.nextInt();
        System.out.print("Enter the array values:\t");
        var arr = new int[size];
        IntStream.range(0, size).forEach(iteration -> arr[iteration] = scanner.nextInt());
        System.out.print("Sorted Array:\n");
        SortingUtils.sort(arr, SortingStrategy.HEAP);
        SortingUtils.print(arr);
    }
}
