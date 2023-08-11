package com.codewithcam;

public class Trie {

    public static final int ALPHABET_SIZE = 26;

    private static class Node {

        private char value;
        private Node[] children = new Node[ALPHABET_SIZE];
        private boolean isEndOfWord;

        public Node() {
        }

        public Node(char value) {
            this.value = value;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public Node[] getChildren() {
            return children;
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    public Node root = new Node(' ');

    public void insert(String word) {

        String wordLower = word.toLowerCase();

        Node current = root;
        for (char c : wordLower.toCharArray()) {
            if (c < 97 || c > 122) throw new IllegalArgumentException();

            int charIndex = c - 'a';
            if (current.getChildren()[charIndex] == null)
                current.getChildren()[charIndex] = new Node(c);

            current = current.getChildren()[charIndex];
        }

        current.setEndOfWord(true);
    }


}
