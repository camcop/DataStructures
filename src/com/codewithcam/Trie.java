package com.codewithcam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

        //        public HashMap<Character, TrieNode> getChildren() {
//            return this.children;
//        }
        public TrieNode[] getChildren() {
            return this.children.values().toArray(new TrieNode[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        public boolean hasChild(char ch) {
            return this.children.containsKey(ch);
        }

        public void addChild(char ch) {
            this.children.put(ch, new TrieNode(ch));
        }

        public TrieNode getChild(char ch) {
            return this.children.get(ch);
        }

        public void setValue(char value) {
            this.value = value;
        }

        public void removeChild(char ch) {
            this.children.remove(ch);
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

    public boolean contains(String word) {

        if (word == null)
            return false;

        TrieNode current = root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (!current.hasChild(c))
                return false;
            current = current.getChild(c);
        }

        return current.isEndOfWord();
    }

    public void traverse() {
        traverse(root);
    }

    private void traverse(TrieNode root) {
//        Pre-order: visit the root first
        System.out.println(root);

        for (TrieNode child : root.getChildren())
            traverse(child);
    }

    public void remove(String word) {
        if (word == null || word.length() == 0) return;

        if (!this.contains(word)) return;

        remove(root, word, 0);
    }

    private void remove(TrieNode node, String word, int index) {

//        Base case
        if (index == word.length()) {
            node.setEndOfWord(false);
            return;
        }

        char ch = word.charAt(index);
        TrieNode child = node.getChild(ch);
        if (child == null) return;

//        Recursive case
        remove(child, word, ++index);

//        Post-order traversal
        if (!child.hasChildren() && !child.isEndOfWord())
            node.removeChild(ch);

    }

    public List<String> autocomplete(String prefix) {

        List<String> out = new ArrayList<>();
        if (prefix == null) return out;

        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.hasChild(c))
                return out;
            node = node.getChild(c);
        }
        autocomplete(node, prefix, out);

        return out;
    }

    private void autocomplete(TrieNode node, String word, List<String> output) {

//        Pre-order traversal (do logic before calling recursion on child)
//        Visit every node
//        Add value to end of the word
//        If node represents end of word, add to List output

        if (node.isEndOfWord())
            output.add(word);

        for (TrieNode child : node.getChildren())
            autocomplete(child, word + child.value, output);

    }


}
