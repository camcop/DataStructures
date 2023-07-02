package com.codewithcam;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class HashTable {

    private class Entry {

        public int key;
        public String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    private static final int MAX_ENTRIES = 8;
    private LinkedList<Entry>[] list = new LinkedList[MAX_ENTRIES];


    private int hash(int key) {
//        return ((key + Integer.parseInt(value)) % MAX_ENTRIES);
        return (key % MAX_ENTRIES);
    }

    public void put(int key, String value) {
        int hash = hash(key);
        if (list[hash] == null)
            list[hash] = new LinkedList<>();

        for (Entry existing : list[hash]) {
            if (existing.key == key) {
                existing.value = value;
                return;
            }
        }
        list[hash].add(new Entry(key, value));
    }

    public String get(int key) {
        int hash = hash(key);
        LinkedList<Entry> linkedList = list[hash];
        if (linkedList == null) throw new NoSuchElementException();
        for (Entry entry : linkedList)
            if (entry.key == key)
                return entry.value;
        throw new NoSuchElementException();
    }

    public void remove(int key) {
        int hash = hash(key);

        LinkedList<Entry> linkedList = list[hash];
        if (linkedList == null) throw new IllegalStateException();

        for (Entry entry : linkedList)
            if (entry.key == key) {
                linkedList.remove(entry);
                return;
            }

        throw new IllegalStateException();
    }

}
