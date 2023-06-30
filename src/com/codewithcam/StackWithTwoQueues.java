package com.codewithcam;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(Integer value) {
        queue2.add(value);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        swapQueues();
    }

    private void swapQueues() {
        while (!queue2.isEmpty())
            queue1.add(queue2.remove());
    }

    public Integer pop() {
        if (isEmpty()) throw new IllegalStateException();
        return queue1.remove();
    }

    public Integer peek() {
        if (isEmpty()) throw new IllegalStateException();
        return queue1.peek();
    }

    public Integer size() {
        return queue1.size();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }


}
