package com.smdev.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashTableTest {
    private HashTable hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new HashTable();
    }

    @Test
    void testPutAndGet() {
        hashTable.put("John Smith", "521-1234");
        hashTable.put("Lisa Smith", "521-8976");
        hashTable.put("Sam Doe", "521-5030");
        hashTable.put("Sandra Dee", "521-9655");
        hashTable.put("Ted Baker", "418-4165");

        Assertions.assertEquals("521-1234", hashTable.get("John Smith"));
        Assertions.assertEquals("521-8976", hashTable.get("Lisa Smith"));
        Assertions.assertEquals("521-5030", hashTable.get("Sam Doe"));
        Assertions.assertEquals("521-9655", hashTable.get("Sandra Dee"));
        Assertions.assertEquals("418-4165", hashTable.get("Ted Baker"));

        hashTable.toString();
    }

    @Test
    void testCollision() {
        // these keys will collide
        hashTable.put("John Smith", "521-1234");
        hashTable.put("Sandra Dee", "521-9655");

        Assertions.assertEquals("521-1234", hashTable.get("John Smith"));
        Assertions.assertEquals("521-9655", hashTable.get("Sandra Dee"));
    }

    @Test
    void testAutoResize() {
        for (int i = 0; i < 100; i++) {
            hashTable.put(i, i);
        }

        Assertions.assertTrue(hashTable.size() == 100);
    }
}
