package com.sam09.org.datastructure.sorting;

public final class SortingFactory {

    private SortingFactory() {
        throw new AssertionError("Sorting Factory instance initialization is prohibited");
    }

    public static BaseSorting getSortingStrategy(SortingStrategy strategy) {
        return switch (strategy) {
            case HEAP -> new HeapSort();
            case SELECTION -> new SelectionSort();
            case INSERTION -> new InsertionSort();
            case MERGE -> new MergeSort();
            case QUICK -> new QuickSort();
            case BUBBLE -> throw new UnsupportedOperationException(String.format("sorting strategy %s is not implemented yet.", strategy.name()));
        };
    }
}
