package com.codewithcam;

public class Heap {

    private int[] items = new int[16];
    private int size = 0;

    public void insert(int value) {

        if (isFull()) throw new IllegalStateException();

        if (isEmpty()) {
            items[0] = value;
            size++;
            return;
        }

        items[size++] = value;
        bubbleUp(size - 1);
    }

    public boolean isFull() {
        return size == items.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void bubbleUp() {
        bubbleUp(size - 1);
    }

    private void bubbleUp(int index) {

        int parentIndex = ((index - 1) / 2);
        if (index == 0 || items[index] < items[parentIndex])
            return;

        swap(index, parentIndex);
        bubbleUp(parentIndex);
    }

    public int remove() {

        if (isEmpty()) throw new IllegalStateException();

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
            swap(index, leftChildIndex);
            bubbleDown(leftChildIndex);
        } else {
            swap(index, rightChildIndex);
            bubbleDown(rightChildIndex);
        }
    }

    private void swap(int first, int second) {
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }


}
