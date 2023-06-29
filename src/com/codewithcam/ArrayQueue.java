package com.codewithcam;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayQueue {

    private int[] items = new int[5];
    private int front = 0;
    private int rear = 0;

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear - front) == items.length;
    }

    public void enqueue(int item) {
        if (isFull()) throw new IllegalStateException();

//        TODO: replace this with circular array logic
        if (front != 0) {
            for (int i = --front; i < rear - 1; i++)
                items[i] = items[i + 1];
            items[rear - 1] = item;
        } else {
            items[rear++] = item;
        }
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException();
        return items[front++];
    }

    public int peek() {
        if (isEmpty()) throw new NoSuchElementException();
        return items[front];
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

}
