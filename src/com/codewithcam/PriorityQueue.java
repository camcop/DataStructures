package com.codewithcam;

public class PriorityQueue {

    private int[] items = new int[5];
    private int count;

    public void insert(int item) {
        if (isFull()) throw new IllegalStateException();

        int i = shiftItemsToInsert(item);
        items[i] = item;
    }

    public int remove() {
        if (isEmpty()) throw new IllegalStateException();

        int next = items[0];

        for (int i = 0; i < count - 1; i++)
            items[i] = items[i + 1];

        items[--count] = 0;
        return next;
    }

    private int shiftItemsToInsert(int item) {
        int i;
        for (i = count++ - 1; i >= 0; i--) {
            if (item < items[i]) {
                items[i + 1] = items[i];
            } else
                break;
        }
        return i + 1;
    }


    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == items.length;
    }

}

