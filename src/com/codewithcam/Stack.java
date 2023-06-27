package com.codewithcam;

import java.util.Arrays;

public class Stack {

    private int[] array = new int[5];
    private int count;

//    public Stack(int length) {
//        array = new int[length];
//    }

    public void push(int value) {
        if (count == array.length) throw new StackOverflowError();
        array[count++] = value;
    }

    public void resize() {
        int[] newArray = new int[array.length * 2];
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        return array[--count];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        return array[count - 1];
    }

    @Override
    public String toString() {
        int[] content = Arrays.copyOfRange(array, 0, count);
        return Arrays.toString(content);
    }

}
