package com.smdev.datastructures;

public class QueueFromStacks {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    int size = 0;

    /**
     * Initialize your data structure here.
     */
    public QueueFromStacks() {
        this.pushStack = new Stack();
        this.popStack = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!this.popStack.isEmpty()) {
            this.pushStack.push(this.popStack.pop());
        }
        this.pushStack.push(x);
        this.size++;
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!this.pushStack.isEmpty()) {
            this.popStack.push(this.pushStack.pop());
        }

        if (this.popStack.isEmpty()) {
            return 0;
        }
        this.size--;
        return this.popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!this.pushStack.isEmpty()) {
            this.popStack.push(this.pushStack.pop());
        }
        if (this.popStack.isEmpty()) {
            return 0;
        }
        return this.popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return this.popStack.isEmpty() && this.pushStack.isEmpty();
    }

    public int size() {
        return this.size;
    }
}
