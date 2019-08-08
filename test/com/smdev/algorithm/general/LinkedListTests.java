package com.smdev.algorithm.general;

import com.smdev.algorithm.general.challenges.T06_LinkedListDuplicateRemover;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTests {

    @Test
    public void test_T06_RemoveDuplicates() {
        // Challenge: Write a method that removes any duplicates from our Linked List.

//        LinkedList<Integer> list1 = new LinkedList<>(Arrays.asList(1, 2, 1));
//        T06_DuplicatesRemover.removeDuplicates(list1);
//        Assert.assertEquals(2, list1.size());

        T06_LinkedListDuplicateRemover list1 = new T06_LinkedListDuplicateRemover(1, 2, 1, 2, 3, 1, 3, 3);
        list1.removeDuplicates();

        Assert.assertEquals(3, list1.size());
    }
}
