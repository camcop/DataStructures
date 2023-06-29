package com.codewithcam;

public class QueueReverser {

    public static ArrayQueue reverse(ArrayQueue queue, int elements) {

        Stack stack1 = new Stack();
        for (int i = 0; i < elements; i++) {
            stack1.push(queue.dequeue());
        }

        ArrayQueue outQueue = new ArrayQueue();
        while (!stack1.isEmpty())
            outQueue.enqueue(stack1.pop());
        while (!queue.isEmpty())
            outQueue.enqueue(queue.dequeue());

        return outQueue;
    }
}
