package com.smdev.datastructures;

public class HashTable<K, V> {

    private static class Entry<K, V> {
        private K key;
        private V value;

        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry[] buckets;
    private int size = 0;
    private int resizeAt;

    public HashTable() {
        this(INITIAL_CAPACITY);
    }

    public HashTable(int capacity) {
        this.buckets = new Entry[capacity];
        this.resizeAt = (int) (capacity * LOAD_FACTOR);
    }

    public void put(K key, V value) {
        int idx = index(key);
        Entry entry = new Entry(key, value);
        if (this.buckets[idx] == null) { // new bucket is created
            this.buckets[idx] = entry;
            this.size++;
            ensureCapacity();
        } else {
            entry.next = this.buckets[idx]; // put in front to avoid loop
            this.buckets[idx] = entry;
        }
    }

    public V get(K key) {
        int idx = index(key);
        Entry entry = this.buckets[idx];
        if (entry == null) {
            return null;
        }

        while (entry != null) {
            if (entry.key.equals(key)) {
                return (V) entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    private int index(K key) {
        int hash = hash(key);
        return Math.abs(hash % this.buckets.length);
    }

    private int hash(K key) {
        return key != null ? key.hashCode() : 0;
    }

    private void ensureCapacity() {
        if (this.size < this.resizeAt) {
            return;
        }

        HashTable tmpHash = new HashTable(this.buckets.length * 2);
        for (Entry e : this.buckets) {
            while (e != null) {
                tmpHash.put(e.key, e.value);
                e = e.next;
            }
        }

        this.buckets = tmpHash.buckets;
        this.size = tmpHash.size;
        this.resizeAt = tmpHash.resizeAt;
    }
}
