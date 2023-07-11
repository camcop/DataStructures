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

        node.height = Math.max(height(node.leftChild), height(node.rightChild)) + 1;

        if (isLeftHeavy(node))
            System.out.println(node.value + " is left heavy");
        else if (isRightHeavy(node))
            System.out.println(node.value + " is right heavy");

        return node;

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

}
