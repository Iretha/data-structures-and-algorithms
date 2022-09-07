package com.smdev.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DynamicArrayTest {

    private DynamicArray array;

    @BeforeEach
    void setUp() {
        array = new DynamicArray<String>(2);
    }

    @Test
    void GetAndSet() {
        array.set(0, "a");
        Assertions.assertEquals("a", array.get(0));
    }

    @Test
    void Insert() {
        array.add("a"); // 0
        array.add("b"); // 1
        array.add("c"); // 2

        array.insert(1, "d");

        Assertions.assertEquals(4, array.size());
        Assertions.assertEquals("a", array.get(0));
        Assertions.assertEquals("d", array.get(1));
        Assertions.assertEquals("b", array.get(2));
        Assertions.assertEquals("c", array.get(3));
    }

    @Test
    void Delete() {
        array.add("a");
        array.add("b");
        array.add("c");

        array.remove(1);

        Assertions.assertEquals(2, array.size());
        Assertions.assertEquals("a", array.get(0));
        Assertions.assertEquals("c", array.get(1));
    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(array.isEmpty());
        array.add("a");
        Assertions.assertFalse(array.isEmpty());
    }
}
