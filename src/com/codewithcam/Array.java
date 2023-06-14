package com.codewithcam;

public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int number) {
        resizeIfNecessary();
        items[count++] = number;
    }

    public void resizeIfNecessary() {
        if (count == items.length) {
            int[] newItems = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            items = newItems;
        }
    }

    public void removeAt(int index) throws IllegalArgumentException {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        else {
            for (int i = index; i < count - 1; i++) {
                items[i] = items[i + 1];
            }
            count--;

//            int[] newItems = new int[count - 1];
//            for (int i = 0; i < count - 1; i++) {
//                if (i < index) {
//                    newItems[i] = items[i];
//                } else {
//                    newItems[i] = items[i + 1];
//                }
//                }
//            items = newItems;
            }
        }

    public int indexOf(int number) {
        for (int i = 0; i < count; i++) {
            if (items[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public int max() {
        if (count == 0) throw new NullPointerException();
        int max = 0;
        for (int i = 0; i < count; i++)
            if (items[i] > max)
                max = items[i];
        return max;
    }

    public Array intersect(Array other) {
//      Change to make sure duplicates are only included if they are duplicated in both arrays
        Array intersection = new Array(count);
        for (int i = 0; i < count; i++) {
            if (!(other.indexOf(items[i]) == -1)) {
                intersection.insert(items[i]);
            }
        }
        return intersection;
    }

    public void reverse() {
        int[] reversed = new int[items.length];
        for (int i = 0; i < count; i++) {
            reversed[i] = items[count - i - 1];
        }
        items = reversed;
    }

    public void insertAt(int item, int index) {
        resizeIfNecessary();
        if (index < 0 || index > count) {
            throw new IllegalArgumentException();
        }
        for (int i = count; i > index; i--)
            items[i] = items[i - 1];
        items[index] = item;
        count++;
    }

}
