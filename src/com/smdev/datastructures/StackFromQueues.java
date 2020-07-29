package com.smdev.datastructures;

import java.util.LinkedList;
import java.util.Queue;

public class StackFromQueues {

    private Queue<Integer> pushQueue;
    private int size = 0;
    private int top;

    /**
     * Initialize your data structure here.
     */
    public StackFromQueues() {
        this.pushQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        this.pushQueue.add(x);
        this.top = x;
        this.size++;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if(this.pushQueue.isEmpty()){
            return 0;
        }
        Queue<Integer> tmp = new LinkedList<>();
        int tmpTop = 0;
        while(this.pushQueue.size() > 1){
            tmpTop = this.pushQueue.poll();
            tmp.add(tmpTop);
        }
        int res = this.pushQueue.poll();
        this.pushQueue = tmp;
        this.top = tmpTop;
        this.size--;
        return res;
    }

    /**
     * Get the top element.
     */
    public int top() {
        return this.top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return this.pushQueue.isEmpty();
    }

    public int size() {
        return size;
    }
}
