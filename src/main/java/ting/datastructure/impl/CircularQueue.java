package ting.datastructure.impl;

public class CircularQueue<E> {
    private final E[] data;
    private int head;
    private int tail;
    private int size;
    private final int capacity;

    public CircularQueue() {
        this(10);
    }

    public CircularQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    // 向队尾插入元素，时间复杂度 O(1)
    public void offer(E e) {
        if (isFull())
            throw new IllegalStateException("Queue Full");

        data[tail] = e;
        tail = (tail + 1) % capacity;
        size++;
    }

    // 从队头删除元素，时间复杂度 O(1)
    public E poll() {
        if (isEmpty())
            throw new IllegalStateException("Queue Empty");

        E first = data[head];
        data[head] = null;
        head = (head + 1) % capacity;
        size--;
        return first;
    }

    // 查看队头元素，时间复杂度 O(1)
    public E peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue Empty");
        return data[head];
    }

    // 返回队列中的元素个数，时间复杂度 O(1)
    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
