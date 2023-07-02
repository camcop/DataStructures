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
        Entry entry = new Entry(key, value);
        if (list[hash] == null)
            list[hash] = new LinkedList<>();
        for (Entry existing : list[hash]) {
            if (existing.key == entry.key) {
                existing.value = entry.value;
                return;
            }
        }
        list[hash].add(entry);
    }

    public String get(int key) {
        int hash = hash(key);
        int i = 0;
        LinkedList<Entry> linkedList = list[hash];
        if (linkedList == null) throw new NoSuchElementException();
        Entry entry = linkedList.element();
        while (entry.key != key && i < linkedList.size())
            entry = linkedList.get(i++);
        if (entry.key == key) return entry.value;
        throw new NoSuchElementException();
    }

    public String remove(int key) {
        int hash = hash(key);
        int i = 0;
        LinkedList<Entry> linkedList = list[hash];
        Entry entry = linkedList.element();
        while (entry.key != key && i < linkedList.size())
            entry = linkedList.get(++i);
        if (entry.key == key) {
            return linkedList.remove(i).value;
        }
        throw new NoSuchElementException();
    }

}
