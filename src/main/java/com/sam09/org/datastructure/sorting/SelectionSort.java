package com.sam09.org.datastructure.sorting;

/**
 * Resource: https://www.udemy.com/course/draft/3571177/learn/lecture/22990274#questions
 */
public class SelectionSort extends AbstractSorting {

    @Override
    public void sort(int[] arr, OrderBy orderBy) {
        validate(arr);
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
            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
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
            if (maxIndex != i) {
                swap(arr, i, maxIndex);
            }
        }
    }
}
