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
        if (reversed.empty()) {
            dumpToReversed();
        }
        return reversed.pop();
    }

    public int peek() {
        if (reversed.empty()) {
            dumpToReversed();
        }
        return reversed.peek();
    }

    public boolean empty() {
        return normal.empty() && reversed.empty();
    }

    private void dumpToReversed() {
        while (!normal.empty()) {
            reversed.push(normal.pop());
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();

        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());  // 應該返回 1，因為這是我們首先推入 queue 的元素
        System.out.println(myQueue.pop());   // 應該返回 1，因為這是我們首先推入 queue 的元素
        System.out.println(myQueue.empty()); // 應該返回 false，因為 queue 中還有一個元素
    }
}
