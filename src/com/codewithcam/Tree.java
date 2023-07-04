package com.codewithcam;

public class Tree {

    private class Node {

        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }


    }

    private Node root;

    public void insert(int value) {

        if (root == null) {
            root = new Node(value);
            return;
        }

        Node current = root;
        Node node = new Node(value);

        Node parent = findParent(value);

//        TODO: case in which node already exists
        if (value < parent.value) {
            parent.leftChild = node;
        } else {
            parent.rightChild = node;
        }

    }

    private Node findParent(int value) {
        Node current = root;

        while (true) {
            if (value < current.value) {
                if (current.leftChild == null)
                    return current;
                current = current.leftChild;
            }
            if (value > current.value) {
                if (current.rightChild == null)
                    return current;
                current = current.rightChild;
            }
        }
    }

    public boolean find(int value) {
//        TODO: correct method
        Node current = root;

//        while (current.leftChild != null || current.rightChild != null) {
//        while (true) {
//            if (value < current.value) {
//                current = current.leftChild;
//            }
//            if (value > current.value) {
//                current = current.rightChild;
//            }
//        }

        return current.value == value;
    }


}
