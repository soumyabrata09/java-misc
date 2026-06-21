package com.sam09.org.datastructure.sorting;


public interface BaseSorting {

    /**
     * @param arr -> input array
     * It is the default sorting by ascending order if not explicit OrderBy is provided
     */
    default void sort(int[] arr) {
        sort(arr, OrderBy.ASC);
    }

    void sort(int[] arr, OrderBy orderBy);
}
