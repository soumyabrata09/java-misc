package com.sam09.org.datastructure.sorting;

import java.util.Arrays;

public class MergeSort extends AbstractSorting {

    private record MergeContext(
            int[] originalArr,
            int[] leftSubArr,
            int[] rightSubArr,
            OrderBy orderBy) {}

    @Override
    public void sort(int[] arr, OrderBy orderBy) {
        validate(arr);
        switch (orderBy) {
            case ASC -> sortByAsc(arr, orderBy);
            case DESC -> sortByDesc(arr, orderBy);
            default -> throw new UnsupportedOperationException("Invalid orderBy operation");
        }
    }

    private void divideAndConquer(int[] arr, int size, OrderBy orderBy) {
        if (size < 2) { // stopping condition
            return;
        }

        var mid = size / 2;

        //create left and right sub-array
        var leftSubArray = Arrays.copyOfRange(arr, 0, mid);
        var rightSubArray = Arrays.copyOfRange(arr, mid, arr.length);
        divideAndConquer(leftSubArray, mid, orderBy);
        divideAndConquer(rightSubArray, size - mid, orderBy);
        merge(new MergeContext(
                arr,
                leftSubArray,
                rightSubArray,
                orderBy)
        );
    }

    private void merge(MergeContext context) {
        var leftIndex = 0;
        var rightIndex = 0;
        var arrIndex = 0;

        while (leftIndex < context.leftSubArr().length
                && rightIndex < context.rightSubArr().length) {

            var shouldTakeLeft = OrderBy.ASC.equals(context.orderBy())
                    ? context.leftSubArr()[leftIndex] <= context.rightSubArr()[rightIndex]
                    : context.leftSubArr()[leftIndex] >= context.rightSubArr()[rightIndex];
            if (shouldTakeLeft) {
                context.originalArr()[arrIndex++] = context.leftSubArr()[leftIndex++];
            } else {
                context.originalArr()[arrIndex++] = context.rightSubArr()[rightIndex++];
            }
        }

        while (leftIndex < context.leftSubArr().length) {
            context.originalArr()[arrIndex] = context.leftSubArr()[leftIndex];
            leftIndex++;
            arrIndex++;
        }

        while (rightIndex < context.rightSubArr().length) {
            context.originalArr()[arrIndex] = context.rightSubArr()[rightIndex];
            rightIndex++;
            arrIndex++;
        }
    }

    private void sortByAsc(int[] arr, OrderBy orderBy) {
        divideAndConquer(arr, arr.length, orderBy);
    }

    private void sortByDesc(int[] arr, OrderBy orderBy) {
        divideAndConquer(arr, arr.length, orderBy);
    }
}
