package ting.leetcode.java.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private final Queue<Integer> queue1;

    private final Queue<Integer> queue2;

    MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.offer(x);
        } else {
            queue1.offer(x);
        }
    }

    public int pop() {
        int last = 0;
        Queue<Integer> inUse = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> notInUse = queue1.isEmpty() ? queue1 : queue2;
        while (!inUse.isEmpty()) {
            last = inUse.poll();
            if (inUse.peek() == null) {
                break;
            }
            notInUse.offer(last);
        }
        return last;
    }

    public int top() {
        int last = 0;
        Queue<Integer> inUse = queue1.isEmpty() ? queue2 : queue1;
        Queue<Integer> notInUse = queue1.isEmpty() ? queue1 : queue2;
        while (!inUse.isEmpty()) {
            last = inUse.poll();
            notInUse.offer(last);
        }
        return last;
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}

