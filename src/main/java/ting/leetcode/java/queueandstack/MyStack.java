package ting.leetcode.java.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private final Queue<Integer> main;

    private final Queue<Integer> cache;

    MyStack() {
        main = new LinkedList<>();
        cache = new LinkedList<>();
    }

    public void push(int x) {
        while (!main.isEmpty()) {
            cache.offer(main.poll());
        }
        main.offer(x);

        while (!cache.isEmpty()) {
            main.offer(cache.poll());
        }
    }

    public int pop() {
        return main.poll();
    }

    public int top() {
        return main.peek();
    }

    public boolean empty() {
        return main.isEmpty();
    }
}

