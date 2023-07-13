package com.codewithcam;

import java.util.ArrayList;
import java.util.List;

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

        if (containsIteration(value)) return;

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

    public boolean containsIteration(int value) {
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

    public Node findNodeIteration(int value) {
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

    public boolean equals(Tree other) {
//        Compare two nodes to see if equal
//        If so, check subtrees to see if equal
//        This is pre-order traversal
//        Use recursion

        return equals(root, other.root);

    }

    private boolean equals(Node first, Node second) {

        if (first == null)
            return second == null;

        if (second == null)
            return false;

        if (first.value != second.value)
            return false;

        return equals(first.leftChild, second.leftChild) && equals(first.rightChild, second.rightChild);
    }


    public boolean validate() {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean validate(Node node, int min, int max) {

        if (node == null)
            return true;

        if (node.value > min && node.value < max)
            return validate(node.leftChild, min, node.value) && validate(node.rightChild, node.value, max);

        return false;
    }

    public ArrayList<Integer> getNodesAtDistance(int k) {
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, k, list);
        return list;
    }

    private void getNodesAtDistance(Node node, int k, ArrayList<Integer> list) {

        if (node == null)
            return;

        if (k == 0)
            list.add(node.value);
        else {
            getNodesAtDistance(node.leftChild, k - 1, list);
            getNodesAtDistance(node.rightChild, k - 1, list);
        }
    }

    public void traverseLevelOrder() {
        for (int i = 0; i <= height(); i++) {
            for (int value : getNodesAtDistance(i))
                System.out.println(value);
        }
    }

    public int size() {
//        Need to check every node
//        Shouldn't matter which traversal algorithm is used

        return size(root, 0);
    }

    private int size(Node node, int count) {

        if (node == null)
            return count;

        count++;

        count = size(node.leftChild, count);
        count = size(node.rightChild, count);
        return count;
    }

    public int countLeaves() {
//        Would make sense to use post order traversal as we are interested in leaf nodes first
        return countLeaves(root, 0);
    }

    private int countLeaves(Node node, int count) {

        if (node == null)
            return count;

        count = countLeaves(node.leftChild, count) + countLeaves(node.rightChild, count);

        if (node.leftChild == null && node.rightChild == null)
            return ++count;

        return count;
    }

    public int max() {
        if (root == null) throw new IllegalStateException();
        return max(root);
    }

    private int max(Node node) {

        if (node.rightChild == null)
            return node.value;

        return max(root.rightChild);

    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {

        if (node == null)
            return false;

        if (node.value == value)
            return true;

        return contains(node.leftChild, value) || contains(node.rightChild, value);

    }

    public boolean areSiblings(int value1, int value2) {
        return areSiblings(root, value1, value2);
    }

    private boolean areSiblings(Node node, int value1, int value2) {

        if (node == null || node.leftChild == null || node.rightChild == null)
            return false;

        if (node.leftChild.value == value1 || node.rightChild.value == value1) {
            if (node.leftChild.value == value2 || node.rightChild.value == value2)
                return true;
        }

        return areSiblings(node.leftChild, value1, value2) || areSiblings(node.rightChild, value1, value2);
    }


    public List<Integer> getAncestors(int value) {
        List<Integer> ancestors = new ArrayList<>();

        if (!contains(value))
            return ancestors;

        return getAncestors(root, value, ancestors);
    }

    private List<Integer> getAncestors(Node node, int value, List<Integer> list) {

        if (node == null)
            return list;

        if (node.value == value)
            return list;

        list.add(node.value);

        if (value < node.value)
            return getAncestors(node.leftChild, value, list);
        else
            return getAncestors(node.rightChild, value, list);

    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
//        Traverse tree from leaves (post order?)
//        At each node, if difference in height of left and right subtrees is greater than 1 it is not balanced
//        If balanced, continue recursion

        if (node == null)
            return true;

        isBalanced(node.leftChild);
        isBalanced(node.rightChild);

        return !(Math.abs(height(node.leftChild) - height(node.rightChild)) > 1);

    }

    public boolean isPerfect() {
//        Tree is perfect if every level except the last is full of nodes
        return (size() == Math.pow(2, height() + 1) - 1);
    }

}