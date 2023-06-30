package com.codewithcam;

import java.util.ArrayDeque;

public class StackWithTwoQueues {

    private ArrayDeque<Integer> queue1 = new ArrayDeque<>();
    private ArrayDeque<Integer> queue2 = new ArrayDeque<>();

    public void push(Integer value) {
        queue1.addFirst(value);
    }

    public Integer pop() {
        return queue1.removeFirst();
    }

    public Integer peek() {
        return queue1.peek();
    }

    public Integer size() {
        return queue1.size();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }


}
