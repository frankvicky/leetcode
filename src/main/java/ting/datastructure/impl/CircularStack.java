package ting.datastructure.impl;

public class CircularStack<E> {
    private final E[] data;
    private int top;
    private int size;
    private final int capacity;

    public CircularStack(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.top = 0;
        this.size = 0;
        this.capacity = capacity;
    }

    public void push(E e) {
        if (isFull())
            throw new IllegalStateException("Stack is full");

        data[top] = e;
        top = (top + 1) % capacity;
        size++;
    }

    // 从栈顶弹出元素，时间复杂度 O(1)
    public E pop() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        top = (top - 1 + capacity) % capacity;
        E value = data[top];
        data[top] = null;
        return value;
    }

    // 查看栈顶元素，时间复杂度 O(1)
    public E peek() {
        if (isEmpty())
            throw new IllegalStateException("Stack is empty");
        return data[(top - 1 + capacity) % capacity];
    }

    // 返回栈中的元素个数，时间复杂度 O(1)
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
