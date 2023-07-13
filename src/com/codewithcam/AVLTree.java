package com.codewithcam;

public class AVLTree {

    private class AVLNode {

        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(value, root);
    }

    private AVLNode insert(int value, AVLNode node) {

        if (node == null)
            return new AVLNode(value);

        if (value < node.value)
            node.leftChild = insert(value, node.leftChild);
        else
            node.rightChild = insert(value, node.rightChild);

        setHeight(node);

        return balance(node);
    }

    private int height(AVLNode node) {
        return (node == null) ? -1 : node.height;
    }

    private int balanceFactor(AVLNode node) {
        return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
    }

    private boolean isLeftHeavy(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRightHeavy(AVLNode node) {
        return balanceFactor(node) < -1;
    }

    private AVLNode balance(AVLNode node) {
        if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0)
                node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        } else if (isRightHeavy(node)) {
            if (balanceFactor(node.rightChild) > 0)
                node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }

        return node;
    }

    private AVLNode rotateLeft(AVLNode node) {

        AVLNode newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;

        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rotateRight(AVLNode node) {

        AVLNode newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;

        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(AVLNode node) {
        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;
    }


}
