package com.smdev.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DoubleLinkedListTest {

    private DoubleLinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new DoubleLinkedList<>();
    }

    @Test
    void addFront() {
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        Assertions.assertEquals(3, linkedList.getFirst());
        Assertions.assertEquals(1, linkedList.getLast());
    }

    @Test
    void getFirst() {
        linkedList.addFront(1);
        Assertions.assertEquals(1, linkedList.getFirst());
    }

    @Test
    void getLast() {
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        Assertions.assertEquals(1, linkedList.getLast());
    }

    @Test
    void addBack() {
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        Assertions.assertEquals(1, linkedList.getFirst());
        Assertions.assertEquals(3, linkedList.getLast());
    }

    @Test
    void size() {
        Assertions.assertEquals(0, linkedList.size());
        linkedList.addBack(1);
        Assertions.assertEquals(1, linkedList.size());
        linkedList.addBack(2);
        Assertions.assertEquals(2, linkedList.size());
    }

    @Test
    void clear() {
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        linkedList.clear();

        Assertions.assertEquals(0, linkedList.size());
    }

    @Test
    void deleteValue() {
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        linkedList.deleteValue(2);

        Assertions.assertEquals(2, linkedList.size());
        Assertions.assertEquals(1, linkedList.getFirst());
        Assertions.assertEquals(3, linkedList.getLast());
    }

    @Test
    void removeFront() {
        linkedList.addFront(1);
        linkedList.addFront(2);
        linkedList.addFront(3);

        linkedList.removeFront();
        linkedList.removeFront();

        Assertions.assertEquals(1, linkedList.getFirst());
    }

    @Test
    void removeBack() {
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        linkedList.removeBack();
        linkedList.removeBack();

        Assertions.assertEquals(1, linkedList.getFirst());
    }

    @Test
    void contains() {
        linkedList.addBack(1);
        linkedList.addBack(2);
        linkedList.addBack(3);

        linkedList.deleteValue(2);

        Assertions.assertTrue(linkedList.contains(1));
        Assertions.assertTrue(!linkedList.contains(2));
        Assertions.assertTrue(linkedList.contains(3));
    }
}
