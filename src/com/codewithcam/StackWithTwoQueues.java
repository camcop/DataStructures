package com.codewithcam;

import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {

    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(Integer value) {
//        queue1.addFirst(value);
        if (queue1.isEmpty()) {
            queue1.add(value);
            while (!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
        } else {
            queue2.add(value);
            while (!queue1.isEmpty()) {
                queue2.add(queue1.remove());
            }
        }
        return;
    }

    public Integer pop() {
//        return queue1.removeFirst();
        if (isEmpty()) throw new IllegalStateException();
        if (queue1.isEmpty())
            return queue2.remove();
        else
            return queue1.remove();
    }

    public Integer peek() {
//        return queue1.peek();
        if (isEmpty()) return null;
        if (queue1.isEmpty())
            return queue2.peek();
        else
            return queue1.peek();

    }

    public Integer size() {
//        return queue1.size();
        if (queue1.isEmpty())
            return queue2.size();
        else
            return queue1.size();

    }

    public boolean isEmpty() {
//        return queue1.isEmpty();
        return (queue1.isEmpty() && queue2.isEmpty());
    }


}
