package com.sam09.org.datastructure.sorting;

import java.util.Objects;

public abstract class AbstractSorting implements BaseSorting {

    void swap (int[] arr, int sourcePosition, int targetPosition) {
        if (sourcePosition == targetPosition) return;

        var temp = arr[targetPosition];
        arr[targetPosition] = arr[sourcePosition];
        arr[sourcePosition] = temp;
    }

    void validate(int[] arr) {
        Objects.requireNonNull(arr, "Array should not be null");
    }
}
