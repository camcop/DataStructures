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

    public Node root;

    public void insert(int value) {

        if (root == null) {
            root = new Node(value);
            return;
        }

        if (contains(value)) return;

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

    public boolean contains(int value) {
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

    public Node find(int value) {
        Node current = root;

        while (current != null) {
            if (value < current.value) {
                current = current.leftChild;
            } else if (value > current.value) {
                current = current.rightChild;
            } else {
                return current;
            }
        }
        return null;

    }

    public void traversePreOrder(Node root) {
        if (root == null) return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
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

//    private Node goLeft(Node node, Set<Node> visited, java.util.Stack<Node> rightChildren) {
//        visited.add(node);
//        System.out.println(node.value);
//        if (node.rightChild != null && !rightChildren.contains(node.rightChild))
//            visited.add(node.rightChild);
//
//        if (node.leftChild == null || visited.contains(node.leftChild))
//            return node;
//
//        return goLeft(node.leftChild, visited, rightChildren);
//    }
