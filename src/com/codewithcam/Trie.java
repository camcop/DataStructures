package com.codewithcam;

import java.util.HashMap;

public class Trie {

    private static class TrieNode {

        private char value;
        private HashMap<Character, TrieNode> children = new HashMap<>();
        private boolean isEndOfWord;

        public TrieNode() {
        }

        public TrieNode(char value) {
            this.value = value;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return this.children;
        }

        public boolean hasChild(char ch) {
            return this.getChildren().containsKey(ch);
        }

        public void addChild(char ch) {
            this.getChildren().put(ch, new TrieNode(ch));
        }

        public com.codewithcam.Trie.TrieNode getChild(char ch) {
            return this.getChildren().get(ch);
        }

        @Override
        public String toString() {
            return "value=" + value;
        }
    }

    public TrieNode root = new TrieNode(' ');

    public void insert(String word) {

        String wordLower = word.toLowerCase();

        TrieNode current = root;
        for (char c : wordLower.toCharArray()) {
            if (c < 97 || c > 122) throw new IllegalArgumentException();

            if (!current.hasChild(c))
                current.addChild(c);

            current = current.getChild(c);
        }

        current.setEndOfWord(true);
    }


}
