---
layout: default
title: Hash Tables
parent: Data Structures
nav_order: 130
description: "Hash Tables"
permalink: /hash-tables
---
# Hash Table (HashMap/ Dictionary)
{: .fs-9 }
 
Hash Tables keep values in (key, value) form for super fast lookup with a constant complexity time O(1).
{: .fs-6 .fw-300 }
---
## How are the Hash Tables implemented?
Hash Tables use array of linked lists for their internal implementation.
The key undergoes a hashing function, that returns a hash code as a result (a numeric representation of the key).
Then the hash code is used to calculate the index of the array, where the element will be stored. 

The formula is:
```
INDEX = Math.abs(HASH CODE % CAPACITY)

The hashcode is divided by the capacity and the remainder is the index. This can return a negative number and we should 
get the absolute value as indexes can't be negative. We will simply use Math.abs(idx) to be sure that we will always have a positive index.
```

Sometimes collisions may occur. A collision is when we get the same index for multiple keys.
To handle the collisions, we use linked lists. If we get multiple elements with the same index, 
we put these element in a single linked list (or in a bucket), located at the specified index in the array. 
This is called "chaining".

Then, when we are looking for an object, we have to "find" the linked list (the bucket) first and then 
we have to iterate through the elements of the linked list to find the element, we are looking for. 
We use "equals" to find the element, when looping through the bucket.

## What the hash function does?
Gets an object and calculates an almost unique number representation of that object. Then the number is used
as an index, that shows where to find the object.
A good hash function should:
* be fast
* reduces collisions
* and generates even distributed numbers

o| SEARCH|INSERT|DELETE
---|---|---|---
A GOOD hash func (few collisions)|O(1)|O(1)|O(1)
A BAD hash func (a lot collisions)|O(N)|O(N)|O(N)

* Bad HashTable means:

More collisions => few linked lists => more elements in a single linked list => more elements to iterate, when looking for something

* Good HashTable means:

Few collisions => more linked lists => few (or 1) elements in a single linked list => less or no elements to iterate, when looking for something

## Glossary:
* Capacity - the capacity is the number of buckets in the HashMap.
* Initial capacity - the capacity when the hashMap is created (In Java the initial capacity is 16 buckets)
* Load Factory - The load factor shows how full the HashMap is allowed to get, before the capacity should be doubled. 
In Java the load factor is 0.75f or 75% of the capacity. 16 * 0.75 = 12 This means, that when the 12th bucket is created,
the capacity from 16 will become 32 and the HashMap will be rehashed.
* "Rehashed" means that with the new capacity the indexes should be recalculated: INDEX = HASH CODE % CAPACITY and elements should be re-bucketed.

## Summary
* Super fast lookup O(1)
* Use hashing to calculate the hash, needed to calculate the index of the bucket
* Handle collisions by chaining elements in the bucket

## Simple Implementation
```java
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

```

