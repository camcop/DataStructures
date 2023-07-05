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

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null) return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null) return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null) return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    public int minBinary() {
//        Returns minimum value in binary search tree
//        O(log n) as we are discarding roughly half the nodes by only searching left children
        if (root == null)
            throw new IllegalStateException();

        Node current = root;
        Node last = current;
        while (current.leftChild != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    public int min() {
        return min(root);
    }

    private int min(Node root) {
//        Returns min value for binary tree (not binary search tree)
//        O(n) as we are required to search all nodes in the tree
        if (isLeaf(root))
            return root.value;

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);

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
