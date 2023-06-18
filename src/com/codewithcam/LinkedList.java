package com.codewithcam;

import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {

        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

    }

    private Node first;
    private Node last;
    private int size;

    public void print() {
        Node node = first;

        while (!(node == null)) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int value) {
        Node node = new Node(value, first);
        if (isEmpty())
            last = node;
        first = node;
        size++;
    }

    public void addLast(int value) {
        Node node = new Node(value);
        if (!isEmpty())
            last.next = node;
        else
            first = node;
        last = node;
        size++;
    }

    public void deleteFirst() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            Node newFirst = first.next;
            first.next = null;
            first = newFirst;
        }
        size--;
    }

    public void deleteLast() {
        if (isEmpty()) throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
        } else {
            Node node = first;
            while (!(node.next == last))
                node = node.next;
            node.next = null;
            last = node;
        }
        size--;
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int indexOf(int value) {
        Node node = first;
        int count = 0;
        while (!(node == null)) {
            if (node.value == value)
                return count;
            node = node.next;
            count++;
        }

        return -1;
    }

    public int size() {
        return size;
    }

}
