package com.codewithcam;

import java.util.NoSuchElementException;

public class HashMap {

    private static class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size = 0;

    private Entry[] entries = new Entry[MAX_ENTRIES];

    private static final int MAX_ENTRIES = 8;

    private int hash(int key) {
        return (key % MAX_ENTRIES);
    }

    private boolean isFull() {
        return size() == MAX_ENTRIES;
    }

    private int getNextEmptySlot(int key) {
        if (isFull()) throw new NoSuchElementException();

        int slot = hash(key);
        Entry bucket = entries[slot];
        while (bucket != null) {
            bucket = entries[(++slot % MAX_ENTRIES)];
        }
        return slot;
    }

    private int getSlot(int key) {
        int slot = hash(key);
        Entry bucket = entries[slot];

        while (bucket != null) {
            if (bucket.key == key) {
                return slot;
            }
            bucket = entries[(++slot % MAX_ENTRIES)];
            if (slot == hash(key)) throw new NoSuchElementException();
        }

        throw new NoSuchElementException();
    }

    public void put(int key, String value) {
        if (isFull()) throw new IllegalStateException();

        entries[getNextEmptySlot(key)] = new Entry(key, value);
        size++;
    }

    public String get(int key) {
        return entries[getSlot(key)].value;
    }

    public String remove(int key) {
        if (size() == 0) throw new IllegalStateException();

        String value = entries[getSlot(key)].value;
        entries[getSlot(key)] = null;
        size--;

        return value;
    }


    public int size() {
        return size;
    }

}
