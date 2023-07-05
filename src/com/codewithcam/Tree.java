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

        if (find(value)) return;

        Node node = new Node(value);

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }

        }

    }

//    private Node findParent(int value) {
//        Node current = root;
//
//        while (true) {
//            if (value < current.value) {
//                if (current.leftChild == null || current.leftChild.value == value)
//                    return current;
//                current = current.leftChild;
//            }
//            if (value > current.value) {
//                if (current.rightChild == null || current.rightChild.value == value)
//                    return current;
//                current = current.rightChild;
//            }
//        }
//    }

    public boolean find(int value) {
        Node current = root;

        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return true;
            }
        }
        return false;

    }


}
