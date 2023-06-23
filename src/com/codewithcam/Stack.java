package com.codewithcam;

public class Stack {

    private int[] array;
    private int count;

    public Stack(int length) {
        array = new int[length];
    }

    public void push(int value) {
        if (count == array.length) {
            int[] newArray = new int[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            newArray[count++] = value;
            array = newArray;
        } else {
            array[count++] = value;
        }
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        int last = array[count - 1];
        array[--count] = 0;
        return last;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int peek() {
        return array[count - 1];
    }

}
