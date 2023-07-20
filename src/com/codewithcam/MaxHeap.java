package com.codewithcam;

public class MaxHeap {

    public static void heapify(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            heapify(array, i);
        }
    }

    private static void heapify(int[] array, int index) {

        int parent = array[index];
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (leftChildIndex >= array.length || rightChildIndex >= array.length)
            return;

        if (parent >= array[leftChildIndex] && parent >= array[rightChildIndex])
            return;

        if (parent < array[leftChildIndex]) {
            int temp = array[leftChildIndex];
            array[leftChildIndex] = parent;
            array[index] = temp;
            heapify(array, leftChildIndex);
        } else {
            int temp = array[rightChildIndex];
            array[rightChildIndex] = parent;
            array[index] = temp;
            heapify(array, rightChildIndex);
        }

    }

}

