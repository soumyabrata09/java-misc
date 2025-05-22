package com.sam09.org.datastructure.sorting;

/**
 * This class represents a sorting behaviour ( HEAP )
 * @author soumyabratasen
 * @link https://www.hackerearth.com/practice/algorithms/sorting/heap-sort/tutorial/
 */
public class HeapSort implements BaseSorting {

    @Override
    public void sort(int[] arr) {
        var length = arr.length;
        
        //Build Max Heap
        for (var i = (length/2 - 1); i >= 0; i--) {
            heapify(arr, length, i);
        }

        //Extract elements from the heap one by one
        for (var last = length -1; last > 0; last--) {
            //Swap current root at the end
            var swap = arr[0];
            arr[0] = arr[last];
            arr[last] = swap;

            //Call heapify with the reduced heap size by 1
            heapify(arr, last, 0);
        }
    }

    private void heapify(int[] arr, int length, int root) {
        var largest = root; //Initialize largest as the root
        var left = root * 2 + 1;
        var right = root * 2 + 2;

        //If left node is larger than the largest
        if (left < length && arr[left] > arr[largest]) {
            largest = left;
        }
        //If right node is larger than the largest
        if (right < length && arr[right] > arr[largest]) {
            largest = right;
        }
        //If largest is not the root
        if (largest != root) {
            var swap = arr[largest];
            arr[largest] = arr[root];
            arr[root] = swap;

            //Recursively heapify respective subtrees
            heapify(arr, length, largest);
        }
    }
}
