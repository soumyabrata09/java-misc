package com.sam09.org.datastructure.sorting;

public class InsertionSort extends AbstractSorting {

    @Override
    public void sort(int[] arr, OrderBy orderBy) {
        validate(arr);
        switch (orderBy) {
            case ASC -> sortByAsc(arr);
            case DESC -> sortByDesc(arr);
            default -> throw new UnsupportedOperationException("Invalid OrderBy option");
        }
    }

    private void sortByAsc(int[] arr) {
        for (var currentIndex = 1; currentIndex < arr.length; currentIndex++) {
            var prevIndex = currentIndex - 1;
            var currentInspectedValue = arr[currentIndex];

            while (prevIndex >= 0 && arr[prevIndex] > currentInspectedValue) {
                arr[prevIndex + 1] = arr[prevIndex];
                prevIndex--;
            }
                // [ 18 6 51 39 4 ]
            arr[prevIndex + 1] = currentInspectedValue;
        }
    }

    private void sortByDesc(int[] arr) {
        for (var currentIndex = 1; currentIndex < arr.length; currentIndex++) {
             var prevIndex = currentIndex - 1;
             var currentInspectedValue = arr[currentIndex];
             while (prevIndex >= 0 && arr[prevIndex] < currentInspectedValue) {
                 arr[prevIndex + 1] = arr[prevIndex];
                 prevIndex--;
             }
             arr[prevIndex + 1] = currentInspectedValue;
        }
    }
}
