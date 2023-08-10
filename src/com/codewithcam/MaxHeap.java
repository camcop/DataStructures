package com.codewithcam;

public class MaxHeap {

    public static void heapify(int[] array) {
        int lastParentIndex = array.length / 2 - 1;
        for (int i = lastParentIndex; i >= 0; i--) {
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
            swap(array, index, leftChildIndex);
            heapify(array, leftChildIndex);
        } else {
            swap(array, index, rightChildIndex);
            heapify(array, rightChildIndex);
        }

    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int getKthLargest(int[] array, int k) {
        if (k < 1 || k > array.length) throw new IllegalArgumentException();

        Heap heap = new Heap();
        for (int n : array)
            heap.insert(n);

        for (int i = 0; i < k - 1; i++)
            heap.remove();

        return heap.max();
    }

}

