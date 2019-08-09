package com.smdev.algorithm.general.challenges;

public class T08_LinkedListLoopDetector {
    public static class Node {
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    private Node root;
    private int size;
    private StringBuilder s = new StringBuilder();

    public T08_LinkedListLoopDetector() {
    }

    public T08_LinkedListLoopDetector(Node... nodes) {
        for (Node n : nodes) {
            add(n);

            this.s.append(n).append(" ");
        }
    }

    public void add(Node n) {
        if (this.root == null) {
            this.root = n;
        } else {
            n.next = this.root;
            this.root = n;
        }
        this.size++;
    }

    public int size() {
        return this.size;
    }

    /**
     * // Challenge: Given a circular linked list, implement an algorithm determines
     * // whether the linked list has a circular loop
     * //
     * // Definition: A circular linked list (corrupt) is one where a node's next pointer
     * // points to an earlier node.
     * // Example
     * // Input: 1 -> 2 -> 3 -> 4 -> 5 -> 3 (same as earlier)
     */
//    public boolean detectLoop() {
//        if (this.root == null || this.size < 2) {
//            return false;
//        }
//
//        Set<Integer> unique = new HashSet<>();
//        Node n = this.root;
//        while (n != null) {
//            if (!unique.add(n.value)) {
//                return true;
//            }
//            n = n.next;
//        }
//        return false;
//    }

    /**
     * Floyd’s Cycle-Finding Algorithm: This is the fastest method and has been described below:
     * <p>
     * Traverse linked list using two pointers.
     * Move one pointer(slow) by one and another pointer(fast) by two.
     * If these pointers meet at the same node then there is a loop.
     * If pointers do not meet then linked list doesn’t have a loop
     */
    public boolean detectLoop() {
        System.out.println();
        System.out.println("====== START: " + this);

        Node slow = this.root;
        Node fast = this.root;
        System.out.println("Start: S: " + slow + " | F: " + fast);

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 hop
            fast = fast.next.next;     // 2 hops

            if (slow == fast) {
                System.out.println("Cycle: S: " + slow + " | F: " + fast);
                return true;
            }else{
                System.out.println("Moving: S: " + slow + " | F: " + fast);
            }
        }
        return false;  // fast reached null, so the list terminates
    }

    @Override
    public String toString() {
        return this.s.reverse().toString();
    }
}
