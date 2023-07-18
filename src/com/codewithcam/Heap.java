package com.codewithcam;

public class Heap {

    private int[] items = new int[8];
    private int size = 0;

    public void insert(int value) {

        if (size == 0) {
            items[0] = value;
            size++;
            return;
        }

        items[size++ - 1] = value;
        bubbleUp(size);
    }

    private void bubbleUp() {
        bubbleUp(size);
    }

    private void bubbleUp(int index) {

        int parentIndex = ((index - 1) / 2);
        if (index == 0 || items[index] < items[parentIndex])
            return;

        int parent = items[parentIndex];
        int item = items[index];
        items[parentIndex] = item;
        items[index] = parent;

        bubbleUp(parentIndex);
    }

    public int remove() {

        int root = items[0];
        int newRoot = items[size - 1];
        items[0] = newRoot;
        items[--size] = 0;

        bubbleDown();
        return root;
    }


    private void bubbleDown() {
        bubbleDown(0);
    }

    private void bubbleDown(int index) {

        int parent = items[index];
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        if (parent >= items[leftChildIndex] && parent >= items[rightChildIndex])
            return;

        if (items[leftChildIndex] >= items[rightChildIndex]) {
            items[index] = items[leftChildIndex];
            items[leftChildIndex] = parent;
            bubbleDown(leftChildIndex);
        } else {
            items[index] = items[rightChildIndex];
            items[rightChildIndex] = parent;
            bubbleDown(rightChildIndex);
        }
    }


}
