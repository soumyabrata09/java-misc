package com.sam09.org.datastructure.sorting;


public interface BaseSorting {

    void sort(int[] arr);

    void sort(int[] arr, OrderBy orderBy);

    default void swap (int[] arr, int sourcePosition, int targetPosition) {
        var temp = arr[targetPosition];
        arr[targetPosition] = arr[sourcePosition];
        arr[sourcePosition] = temp;
    }
}
