package com.codewithcam;

public class LinkedList {

    private Node first;
    private Node last;

    public void print() {
        Node node = first;
//        int count = 0;

        while (!(node.getNext() == null)) {
            System.out.println(node.getValue());
//            count++;
            node = node.getNext();
        }
        System.out.println(node.getValue());
    }

    public void addFirst(int value) {
        Node node = new Node(value, first);
        if (first == null)
            last = node;
        first = node;
    }

    public void addLast(int value) {
        Node newLast = new Node(value, null);
        if (last != null)
            last.setNext(newLast);
        else
            first = newLast;
        last = newLast;
    }

    public void deleteFirst() {
        Node newFirst = first.getNext();
        first.setNext(null);
        first = newFirst;
    }

    public void deleteLast() {
        Node node = first;
        while (!(node.getNext() == last))
            node = node.getNext();
        node.setNext(null);
        last = node;
    }

    public boolean contains(int value) {
        Node node = first;
        while (!(node == last)) {
            if (node.getValue() == value)
                return true;
            node = node.getNext();
        }
        if (node.getValue() == value)
            return true;
        return false;
    }

    public int indexOf(int value) {
        Node node = first;
        int count = 0;
        while (!(node == last)) {
            if (node.getValue() == value)
                return count;
            node = node.getNext();
            count++;
        }
        if (node.getValue() == value)
            return count;

        return -1;
    }


}
