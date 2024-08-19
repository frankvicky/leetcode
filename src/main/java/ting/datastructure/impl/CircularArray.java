package ting.datastructure.impl;

public class CircularArray<E> {
    // 注意這裡 start, end 是使用左閉右開 [start, end)
    // start 指針一定會有元素，end 則一定在最後一個元素的下一個空位，所以沒有元素。
    private E[] data;
    private int start;
    private int end;
    private int size;
    private int capacity;

    public CircularArray(int size) {
        this.size = size;
        this.data = (E[]) new Object[size];
    }

    public CircularArray() {
        this(10);
    }

    private void resize(int newCapacity) {
        E[] newContainer = (E[]) new Object[newCapacity];
        E[] oldContainer = this.data;

        for (int i = 0; i < size; i++) {
            newContainer[i] = oldContainer[i];
        }

        this.data = newContainer;
        start = 0;
        end = size;
        capacity = newCapacity;
    }

    public void addFirst(E e) {
        if (isFull())
            resize(capacity << 1);

        // start 為閉區間，所以先左移，再賦值 ( if ( start <= index && index < end) -> if ( start - 1 <= index && index < end) )
        start = (start - 1 + capacity) % capacity;
        data[start] = e;
        size++;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new IllegalStateException("Array is empty");

        data[start] = null;
        start = (start + 1) % capacity;
        size--;
    }

    public void addLast(E e) {
        if (isFull())
            resize(capacity << 1);

        data[end] = e;
        end = (end + 1) % capacity;
        size++;
    }

    public void removeLast() {
        if (isEmpty())
            throw new IllegalStateException("Array is Empty");

        end = (end - 1 + capacity) % capacity;
        data[end] = null;
        size--;
    }

    public E getFirst() {
        if (isEmpty())
            throw new IllegalStateException("Array is Empty");
        return data[start];
    }

    public E getLast() {
        if (isEmpty())
            throw new IllegalStateException("Array is Empty");
        return data[(end - 1 + capacity) % capacity];
    }

    private boolean isFull() {
        return size == capacity;
    }

    private boolean isEmpty() {
        return size == 0;
    }
}
