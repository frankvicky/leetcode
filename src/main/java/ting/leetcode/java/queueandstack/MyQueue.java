package ting.leetcode.java.queueandstack;

import java.util.Stack;

class MyQueue {
    private final Stack<Integer> normal;
    private final Stack<Integer> reversed;

    public MyQueue() {
        normal = new Stack<>();
        reversed = new Stack<>();
    }

    public void push(int x) {
        normal.push(x);
    }

    public int pop() {
        if (!reversed.isEmpty()) {
            return reversed.pop();
        }

        while (!normal.isEmpty()) {
            reversed.push(normal.pop());
        }

        return reversed.pop();
    }

    public int peek() {
        if (!reversed.isEmpty()) {
            return reversed.peek();
        }

        while (!normal.isEmpty()) {
            reversed.push(normal.pop());
        }
        return reversed.peek();
    }

    public boolean empty() {
        return normal.isEmpty() && reversed.isEmpty();
    }
}