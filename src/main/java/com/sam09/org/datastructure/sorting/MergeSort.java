package com.sam09.org.datastructure.sorting;

public class MergeSort implements BaseSorting {

    private record MergeContext(
            int[] originalArr,
            int[] leftSubArr,
            int[] rightSubArr,
            int leftSubArrSize,
            int rightSubArrSize,
            OrderBy orderBy) {}

    @Override
    public void sort(int[] arr) {
        throw new UnsupportedOperationException("Invalid operation");
    }

    @Override
    public void sort(int[] arr, OrderBy orderBy) {
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
        var leftSubArray = new int[mid];
        var rightSubArray = new int[size - mid];

        //create left and right sub-array
        for (var i = 0; i < mid; i++) {
            leftSubArray[i] = arr[i];
        }
        for (var j = mid; j < size; j++) {
            rightSubArray[j - mid] = arr[j];
        }
        divideAndConquer(leftSubArray, mid, orderBy);
        divideAndConquer(rightSubArray, size - mid, orderBy);
        merge(new MergeContext(
                arr,
                leftSubArray,
                rightSubArray,
                mid,
                (size - mid),
                orderBy)
        );
    }

    private void merge(MergeContext context) {
        var leftIndex = 0;
        var rightIndex = 0;
        var arrIndex = 0;

        while (leftIndex < context.leftSubArrSize() && rightIndex < context.rightSubArrSize()       ) {
            /*if (leftSubArr[leftIndex] <= rightSubArr[rightIndex]) {
                originalArr[arrIndex] = leftSubArr[leftIndex];
                leftIndex++;
            } else {
                originalArr[arrIndex] = rightSubArr[rightIndex];
                rightIndex++;
            }*/
            if (OrderBy.ASC.equals(context.orderBy())) {
                if(context.leftSubArr()[leftIndex] <= context.rightSubArr()[rightIndex]) {
                    /**
                     *  originalArr[arrIndex] = leftSubArr[leftIndex];
                     *  leftIndex++;
                     *
                     *  outerlopp: arrIndex++;
                     *
                     *  short hand version: originalArr[arrIndex++] = rightSubArr[leftSubArray++]
                     */
                    context.originalArr()[arrIndex++] = context.leftSubArr()[leftIndex++];
                } else {
                    context.originalArr()[arrIndex++] = context.rightSubArr()[rightIndex++];
                }
            } else {
                if (context.leftSubArr()[leftIndex] >= context.rightSubArr()[rightIndex]) {
                    context.originalArr()[arrIndex++] = context.leftSubArr()[leftIndex++];
                } else {
                    context.originalArr()[arrIndex++] = context.rightSubArr()[rightIndex++];
                }
            }
//            arrIndex++;
        }

        while (leftIndex < context.leftSubArrSize()) {
            context.originalArr()[arrIndex] = context.leftSubArr()[leftIndex];
            leftIndex++;
            arrIndex++;
        }

        while (rightIndex < context.rightSubArrSize()) {
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
