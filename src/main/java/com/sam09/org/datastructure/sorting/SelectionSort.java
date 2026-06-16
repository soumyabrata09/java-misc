package com.sam09.org.datastructure.sorting;

/**
 * Resource: https://www.udemy.com/course/draft/3571177/learn/lecture/22990274#questions
 */
public class SelectionSort implements BaseSorting {

    @Override
    public void sort(int[] arr) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sort(int[] arr, OrderBy orderBy) {
        switch (orderBy) {
            case OrderBy.ASC -> sortByAsc(arr);
            case OrderBy.DESC -> sortByDesc(arr);
            default -> throw new UnsupportedOperationException("Unsupported sorting operation type");
        }
    }

    private void sortByAsc(int[] arr) {
        for (var i = 0; i < arr.length - 1; i++) {
            var minIndex = i;
            for (var j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private void sortByDesc(int[] arr) {
        for (var i = 0; i < arr.length - 1; i++) {
            var maxIndex = i;
            for (var j = i + 1; j < arr.length; j++) {
                if (arr[maxIndex] < arr[j]) {
                    maxIndex = j;
                }
            }
            swap(arr, i, maxIndex);
        }
    }
}
