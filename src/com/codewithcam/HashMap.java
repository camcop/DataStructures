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
        Entry entry = entries[slot];
        while (entry != null) {
            slot = (++slot % MAX_ENTRIES);
            entry = entries[slot];
        }
        return slot;
    }

    private int getSlot(int key) {
        int slot = hash(key);
        Entry entry = entries[slot];

//      This loop may terminate one iteration too early if the slot for the key is located at hash(key) - 1
        while (slot != hash(key) - 1) {
            if (entry != null && entry.key == key)
                return slot;
            slot = (++slot % MAX_ENTRIES);
            entry = entries[slot];
        }

        return -1;
    }

    public void put(int key, String value) {
        if (isFull()) throw new IllegalStateException();

        int slot = getSlot(key);
        if (slot == -1) {
            entries[getNextEmptySlot(key)] = new Entry(key, value);
            size++;
        } else {
            entries[slot].value = value;
        }

    }

    public String get(int key) {
        int slot = getSlot(key);
        if (slot == -1) throw new NoSuchElementException();

        return entries[slot].value;
    }

    public String remove(int key) {
        if (size() == 0) throw new IllegalStateException();

        int slot = getSlot(key);
        if (slot == -1) throw new NoSuchElementException();

        String value = entries[slot].value;
        entries[slot] = null;
        size--;

        return value;
    }


    public int size() {
        return size;
    }

}
