package ting.leetcode.java.queueandstack;

import java.util.LinkedList;

public class ImplementQueueByLinkedList {

    private final LinkedList<Integer> queue = new LinkedList<>();
    public void enqueue(int item) {
        queue.offer(item);
    }

    public int dequeue() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.poll();
    }
}
