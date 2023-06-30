package com.codewithcam;

public class LinkedListQueue {

    private LinkedList list;

    public void enqueue(int item) {
//        O(1)
        list.addLast(item);
    }

    public int dequeue() {
//        O(1)
        return list.deleteFirst();
    }

    public int peek() {
//        O(1)
        return list.getFirst();
    }

    public int size() {
//        O(1)
        return list.size();
    }

    public boolean isEmpty() {
//        O(1)
        return list.isEmpty();
    }

}
