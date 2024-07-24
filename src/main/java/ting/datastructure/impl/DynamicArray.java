package ting.datastructure.impl;

import java.util.NoSuchElementException;

public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private E[] data;
    // record the current size
    private int size;

    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int initialCapacity) {
        data = (E[]) new Object[initialCapacity];
        size = 0;
    }

    public void addLast(E e) {
        resizeIfNeeded();

        data[size] = e;
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        resizeIfNeeded();

        // 此處不可以正序搬移，會把後面的數據蓋掉
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        data[size - 1] = null;
        size--;
    }

    public void remove(int index) {
        checkElementIndex(index);

        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
    }

    public void removeFirst() {
        remove(0);
    }

    public E get(int index) {
        checkElementIndex(index);
        return data[index];
    }

    public void set(int index, E e) {
        checkElementIndex(index);
        data[index] = e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resizeIfNeeded() {
        int maximumSize = data.length;

        if (size == maximumSize) {
            resize(size << 1);
        }
    }

    private void checkElementIndex(int index) {
        if (index >= 0 && index < size) {
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void checkPositionIndex(int index) {
        if (index >= 0 && index <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    private void resize(int newCapacity) {
        E[] newContainer = (E[]) new Object[newCapacity];

        for (int i = 0; i < data.length; i++) {
            newContainer[i] = data[i];
        }

        data = newContainer;
    }
}
