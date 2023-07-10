package com.codewithcam;

public class AVLTree {

    private class AVLNode {

        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;

        public AVLNode(int value) {
            this.value = value;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        if (root == null) {
            root = new AVLNode(value);
        }
        insert(value, root);

    }

    private void insert(int value, AVLNode node) {

        AVLNode newNode = new AVLNode(value);

        if (value < node.value && node.leftChild == null) {
            node.leftChild = newNode;
            return;
        }
        if (value > node.value && node.rightChild == null) {
            node.rightChild = newNode;
            return;
        }
        if (value < node.value)
            insert(value, node.leftChild);
        if (value > node.value)
            insert(value, node.rightChild);


    }

}
