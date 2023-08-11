package com.codewithcam;

import java.util.HashMap;

public class Trie {

    public static final int ALPHABET_SIZE = 26;

    private static class Node {

        private char value;
        private HashMap<Character, Node> children = new HashMap<>();
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

        public HashMap<Character, Node> getChildren() {
            return this.children;
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

            current.getChildren().putIfAbsent(c, new Node(c));
            current = current.getChildren().get(c);
        }

        current.setEndOfWord(true);
    }


}
