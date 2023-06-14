package com.codewithcam;

public class LinkedList {

    private Node first;
    private Node last;

    public void print() {
        Node node = first;
        while (!(node == last)) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public void addFirst(int value) {
        if (this.getFirst() == null)
            this.first =
        this.first = new Node(value, this.getFirst());
    }

    public void addLast(int value) {
        Node newLast = new Node(value, null);
        if (this.last == null)
            this.last = newLast;
        else
            this.last.setNext(newLast);

        this.setLast(newLast);
    }

    public void deleteFirst() {
        this.setFirst(this.first.getNext());
        this.first.setNext(null);
    }

    public void deleteLast() {
        Node node = this.first;
        while (!(node == last))
            node = node.getNext();
        this.setLast(node);
//        May need to set value of second last node to null for it to be garbage collected
    }

    public boolean contains(int value) {
        Node node = this.first;
        while (!(node == last)) {
            if (node.getValue() == value)
                return true;
            node = node.getNext();
        }
        return false;
    }

    public int indexOf(int value) {
        Node node = this.first;
        int count = 0;
        while (!(node == last)) {
            if (node.getValue() == value)
                return count;
            node = node.getNext();
            count++;
        }
        return -1;
    }


}
