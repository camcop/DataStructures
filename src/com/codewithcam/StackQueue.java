package com.codewithcam;

public class StackQueue {

    private Stack stack1 = new Stack();
    private Stack stack2 = new Stack();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) throw new IllegalStateException();

        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

//    public boolean isFull() {
//        return stack1.;
//    }

    public int peek() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        return stack2.peek();
    }


}
