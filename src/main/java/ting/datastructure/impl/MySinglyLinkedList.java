package ting.datastructure.impl;

import java.util.NoSuchElementException;

// 重點：虛擬節點用於應對邊際情況、索引檢查、size 維護、頭尾指針維護
public class MySinglyLinkedList<E> {
    private static class Node<E> {
        E val;
        Node<E> next;

        public Node(E val) {
            this.val = val;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MySinglyLinkedList() {
        this.head = new Node<>(null); // dummyNode, 用來處理邊界情況
        this.tail = head;
        this.size = 0;
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head.next;
        head.next = newNode;
        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void add(int index, E e) {
        checkPositionIndex(index);
        if (size == index) {
            addLast(e);
            return;
        }

        Node<E> prev = head;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node<E> newNode = new Node<>(e);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<E> first = head.next;
        head.next = first.next;

        if (size == 1) {
            tail = head;
        }

        size--;
    }

    public void removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<E> prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }

        prev.next = null;
        tail = prev;
        size--;
    }

    public void remove(int index) {
        checkPositionIndex(index);
        Node<E> prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node<E> target = prev.next;
        prev.next = target.next;

        if (index == size - 1) {
            // if target is last element, we need to maintain tail pointer.
            tail = prev;
        }
        size--;
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    public E getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return getNode(size - 1).val;
    }

    public E get(int index) {
        return getNode(index).val;
    }

    public void set(int index, E e) {
        getNode(index).val = e;
    }

    public int size() {
        return size;
    }


    private Node<E> getNode(int index) {
        checkElementIndex(index);
        Node<E> pointer = head.next;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    private void checkPositionIndex(int index) {
        if (index >= 0 && index <= size) {
            return;
        }
        throw new IndexOutOfBoundsException();
    }

    private void checkElementIndex(int index) {
        if (index >= 0 && index < size) {
            return;
        }
        throw new IndexOutOfBoundsException();
    }
}
