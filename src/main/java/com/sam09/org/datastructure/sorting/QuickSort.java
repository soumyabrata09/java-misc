package com.sam09.org.datastructure.sorting;

public class QuickSort extends AbstractSorting {

    @Override
    public void sort(int[] arr, OrderBy orderBy) {
        validate(arr);
        switch (orderBy) {
            case ASC -> sortByAsc(arr);
            case DESC -> sortByDesc(arr);
            default -> throw new UnsupportedOperationException("Invalid operation");
        }
    }

    private int partition(int[] arr, int low, int high, OrderBy orderBy) {
        var pivot = arr[high];
        var partitionIndex = low;
        for (var currentIndex = low; currentIndex < high; currentIndex++) {
            if (orderBy.equals(OrderBy.ASC)) {
                if (arr[currentIndex] < pivot) {
                    swap(arr, partitionIndex, currentIndex);
                    partitionIndex++;
                }
            } else {
                if (arr[currentIndex] > pivot) {
                    swap(arr, partitionIndex, currentIndex);
                    partitionIndex++;
                }
            }

        }
        swap(arr, partitionIndex, high);

        return partitionIndex;
    }

    private void doSort(int[] arr, int low, int high, OrderBy orderBy) {
        if (low < high) {
            var pivotIndex = partition(arr, low, high, orderBy);
            doSort(arr, low, pivotIndex - 1, orderBy);
            doSort(arr, pivotIndex + 1, high, orderBy);
        }
    }

    private void sortByDesc(int[] arr) {
        doSort(arr, 0, arr.length - 1, OrderBy.DESC);
    }

    private void sortByAsc(int[] arr) {
        doSort(arr, 0, arr.length - 1, OrderBy.ASC);
    }
}
