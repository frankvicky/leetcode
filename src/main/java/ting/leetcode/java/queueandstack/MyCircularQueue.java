package ting.leetcode.java.queueandstack;

import java.util.Arrays;


public class MyCircularQueue {
    private final int[] arr;
    private final int capacity;
    private int head = 0;
    private int tail = 0;
    private int size = 0;

    public MyCircularQueue(int k) {
        arr = new int[k];
        Arrays.fill(arr, -1);
        capacity = k;
    }

    public boolean enQueue(int value) {
        if (size == capacity)
            return false;
        arr[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (size == 0)
            return false;
        arr[head] = -1;
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        int i = head + capacity;
        return arr[i % capacity];
    }

    public int Rear() {
        int i = tail + capacity - 1;
        return arr[i % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}