package com.codewithcam;

import java.util.LinkedList;

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


    public void put(int key, String value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(new Entry(key, value));

    }

    public String get(int key) {
        Entry entry = getEntry(key);

        return entry == null ? null : entry.value;
    }

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry == null) throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    private int hash(int key) {
        return (key % MAX_ENTRIES);
    }

    private LinkedList<Entry> getBucket(int key) {
        return list[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        LinkedList<Entry> linkedList = getBucket(key);
        if (linkedList == null)
            list[hash(key)] = new LinkedList<>();

        return list[hash(key)];
    }

    private Entry getEntry(int key) {
        LinkedList<Entry> list = getBucket(key);

        if (list != null) {
            for (Entry entry : list)
                if (entry.key == key)
                    return entry;
        }

        return null;
    }


}
